package gradproj.demo.config;

import gradproj.demo.auth.interceptors.AdminCheckInterceptor;
import gradproj.demo.auth.interceptors.SelfCheckInterceptor;
import gradproj.demo.auth.interceptors.LoginCheckInterceptor;
import gradproj.demo.auth.interceptors.SelfOrAdminCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/logout")
                .addPathPatterns("/comments/write")
                .addPathPatterns("/dboard/create")
                .addPathPatterns("/discuss/write")
                .addPathPatterns("/question/write")
                .excludePathPatterns();
        registry.addInterceptor(new SelfOrAdminCheckInterceptor())
                .order(2)
                .addPathPatterns("/comments/update", "/comments/delete")
                .addPathPatterns("/discuss/update", "/discuss/delete")
                .addPathPatterns("/member/withdraw")
                .addPathPatterns("/question/update")
                .excludePathPatterns();
        registry.addInterceptor(new SelfCheckInterceptor())
                .order(3)
                .addPathPatterns("/logout")
                .addPathPatterns("/member", "/member/nickname", "/member/password", "/member/bookmark")
                .excludePathPatterns();
        registry.addInterceptor(new AdminCheckInterceptor())
                .order(4)
                .addPathPatterns("/notice/write", "/notice/update", "/notice/delete")
                .excludePathPatterns();
    }
}
