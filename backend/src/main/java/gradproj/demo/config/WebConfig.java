package gradproj.demo.config;

import gradproj.demo.auth.interceptors.AdminCheckInterceptor;
import gradproj.demo.auth.interceptors.SelfCheckInterceptor;
import gradproj.demo.auth.interceptors.LoginCheckInterceptor;
import gradproj.demo.auth.interceptors.SelfOrAdminCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final LoginCheckInterceptor loginCheckInterceptor;
    private final SelfOrAdminCheckInterceptor selfOrAdminCheckInterceptor;
    private final SelfCheckInterceptor selfCheckInterceptor;
    private final AdminCheckInterceptor adminCheckInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "http://localhost:5173", "http://frontend:5173")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .order(1)
                .addPathPatterns("/logout")
                .addPathPatterns("/comments/write")
                .addPathPatterns("/dboard/create")
                .addPathPatterns("/discuss/write")
                .addPathPatterns("/question/write")
                .excludePathPatterns();
        registry.addInterceptor(selfOrAdminCheckInterceptor)
                .order(2)
                .addPathPatterns("/comments/update", "/comments/delete")
                .addPathPatterns("/discuss/update", "/discuss/delete")
                .addPathPatterns("/member/withdraw")
                .addPathPatterns("/question/update")
                .excludePathPatterns();
        registry.addInterceptor(selfCheckInterceptor)
                .order(3)
                .addPathPatterns("/logout")
                .addPathPatterns("/member", "/member/nickname", "/member/password", "/member/bookmark")
                .excludePathPatterns();
        registry.addInterceptor(adminCheckInterceptor)
                .order(4)
                .addPathPatterns("/notice/write", "/notice/update", "/notice/delete")
                .excludePathPatterns();
    }
}
