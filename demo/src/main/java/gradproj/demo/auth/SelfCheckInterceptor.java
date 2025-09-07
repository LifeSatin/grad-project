package gradproj.demo.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

// 본인인지 체크하는 인터셉터
@Slf4j
public class SelfCheckInterceptor implements HandlerInterceptor {

    // 요청에 제출된 토큰을 분석해 해당 글의 작성자와 동일인이면 넘기면 될듯.
    // 해당 페이지가 게시글이라는 점을 코드로 표현하는 게 문제일 듯?

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[IdCheckInterceptor] prehandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
