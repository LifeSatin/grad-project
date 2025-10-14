package gradproj.demo.auth.interceptors;

import gradproj.demo.auth.AuthService;
import gradproj.demo.auth.dto.service.request.CRequestAdminCheckDto;
import gradproj.demo.auth.dto.service.response.CResponseAdminCheckDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 관리자인지 체크하는 인터셉터
@Slf4j
@Component
@RequiredArgsConstructor
public class AdminCheckInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[AdminCheckInterceptor] preHandle");
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            log.info("[AdminCheckInterceptor] no cookies");
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
            log.info("[AdminCheckInterceptor] no session-id");
            // throw new RuntimeException();
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }

        CResponseAdminCheckDto cdto = authService.adminCheck(new CRequestAdminCheckDto(sessionId));
        if (!cdto.result) {
            log.info("[AdminCheckInterceptor] invalid session-id");
            // throw new RuntimeException();
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
