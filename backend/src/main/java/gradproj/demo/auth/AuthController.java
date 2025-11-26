package gradproj.demo.auth;

import gradproj.demo.auth.dto.controller.*;
import gradproj.demo.auth.dto.service.request.CRequestLoginDto;
import gradproj.demo.auth.dto.service.request.CRequestUserDto;
import gradproj.demo.auth.dto.service.response.CResponseLoginDto;
import gradproj.demo.auth.dto.service.response.CResponseUserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 로그인 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param loginId, password
     * @return token
     */
    @PostMapping("/login")
    public ResponseLoginDto login(RequestLoginDto dto, HttpServletResponse response) {
        // 제출된 회원정보와 대조하고 일치하면 유효 토큰 생성 및 발급
        log.info("[AuthController:login] id: " + dto.getLoginId() + ", password: " + dto.getPassword());
        CResponseLoginDto cdto = authService.login(new CRequestLoginDto(dto.getLoginId(), dto.getPassword()));
        log.info("[AuthController:login] token: " + cdto.getToken());
        return new ResponseLoginDto(cdto.getToken());
    }

    /**
     * 로그아웃 기능
     * 구현 상태: 미구현
     * 요구 권한: 본인
     * @param
     * @retyrn
     */
    @GetMapping("/logout")
    public ResponseLogoutDto logout() {
        // 같이 제출된 토큰 정보를 이용하여 해당 토큰을 무효화
        return new ResponseLogoutDto();
    }

    @GetMapping("/user")
    public ResponseUserDto getUser(RequestUserDto dto) {
        CResponseUserDto cdto = authService.getUser(new CRequestUserDto(dto.getToken()));
        return new ResponseUserDto(cdto.status, cdto.username);
    }
}
