package gradproj.demo.auth.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

// 관리자인지 체크하는 인터셉터
@Slf4j
public class AdminCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[AdminCheckInterceptor] preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
