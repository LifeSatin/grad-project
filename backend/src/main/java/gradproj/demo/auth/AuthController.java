package gradproj.demo.auth;

import gradproj.demo.auth.dto.controller.RequestLoginDto;
import gradproj.demo.auth.dto.controller.ResponseLoginDto;
import gradproj.demo.auth.dto.service.request.CRequestLoginDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 로그인 기능
     * 구현 상태: 미구현
     * 요구 권한: 없음
     * @param loginId, password
     * @return token
     */
    @GetMapping("/login")
    public ResponseLoginDto login(RequestLoginDto dto) {
        // 제출된 회원정보와 대조하고 일치하면 유효 토큰 생성 및 발급
        authService.login(new CRequestLoginDto(dto.getLoginId(), dto.getPassword()));
        return new ResponseLoginDto();
    }

    /**
     * 로그아웃 기능
     * 구현 상태: 미구현
     * 요구 권한: 본인
     * @param
     * @retyrn
     */
    @GetMapping("/logout")
    public void logout() {
        // 같이 제출된 토큰 정보를 이용하여 해당 토큰을 무효화
    }
}
