package gradproj.demo.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

// 로그인 되었는지 체크하는 인터셉터
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    // 요청에 제출된 토큰의 유효성을 검사하면 되지 않을까?

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[LoginCheckInterceptor] preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
