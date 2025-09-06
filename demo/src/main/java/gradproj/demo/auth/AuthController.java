package gradproj.demo.auth;

import gradproj.demo.auth.dto.RequestLoginDto;
import gradproj.demo.auth.dto.ResponseLoginDto;
import gradproj.demo.auth.dto.CRequestLoginDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 로그인
    @GetMapping("/login")
    public ResponseLoginDto login(RequestLoginDto dto) {
        authService.login(new CRequestLoginDto());
        return new ResponseLoginDto();
    }
}
