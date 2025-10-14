package gradproj.demo.auth.interceptors;

import gradproj.demo.auth.AuthController;
import gradproj.demo.auth.AuthService;
import gradproj.demo.auth.dto.service.request.CRequestLoginCheckDto;
import gradproj.demo.auth.dto.service.response.CResponseLoginCheckDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 로그인 되었는지 체크하는 인터셉터
@Slf4j
@Component
@RequiredArgsConstructor
public class LoginCheckInterceptor implements HandlerInterceptor {

    // 요청에 제출된 토큰의 유효성을 검사하면 되지 않을까?

    private final AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[LoginCheckInterceptor] preHandle");
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            log.info("[LoginCheckInterceptor] no cookies");
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
            log.info("[LoginCheckInterceptor] no session-id");
            // throw new RuntimeException();
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }

        CResponseLoginCheckDto cdto = authService.loginCheck(new CRequestLoginCheckDto(sessionId));
        if (!cdto.result) {
            log.info("[LoginCheckInterceptor] invalid session-id");
            // throw new RuntimeException();
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
