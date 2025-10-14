package gradproj.demo.auth.interceptors;

import gradproj.demo.auth.AuthService;
import gradproj.demo.auth.dto.service.request.CRequestAdminCheckDto;
import gradproj.demo.auth.dto.service.request.CRequestSelfCheckDto;
import gradproj.demo.auth.dto.service.response.CResponseAdminCheckDto;
import gradproj.demo.auth.dto.service.response.CResponseSelfCheckDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 본인인지 체크하는 인터셉터
@Slf4j
@Component
@RequiredArgsConstructor
public class SelfCheckInterceptor implements HandlerInterceptor {

    // 요청에 제출된 토큰을 분석해 해당 글의 작성자와 동일인이면 넘기면 될듯.
    // 해당 페이지가 게시글이라는 점을 코드로 표현하는 게 문제일 듯?

    private final AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[IdCheckInterceptor] prehandle");
        request.getQueryString();
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            log.info("[SelfCheckInterceptor] no cookies");
            // throw new RuntimeException();
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        String sessionId = "";
        for (Cookie c : cookies) {
            if (c.getName().equals("session-id")) {
                sessionId = c.getValue();
            }
        }
        if (sessionId.equals("")) {
            log.info("[SelfCheckInterceptor] no session-id");
            // throw new RuntimeException();
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }

        CResponseSelfCheckDto cdto = authService.selfCheck(new CRequestSelfCheckDto(sessionId));
        if (!cdto.result) {
            log.info("[SelfCheckInterceptor] invalid session-id");
            // throw new RuntimeException();
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
