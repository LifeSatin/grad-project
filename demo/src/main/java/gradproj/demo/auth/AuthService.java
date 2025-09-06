package gradproj.demo.auth;

import gradproj.demo.auth.dto.CRequestLoginDto;
import gradproj.demo.auth.dto.CResponseLoginDto;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public CResponseLoginDto login(CRequestLoginDto dto) {
        // 후추
        return new CResponseLoginDto();
    }
}
