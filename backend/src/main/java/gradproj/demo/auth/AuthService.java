package gradproj.demo.auth;

import gradproj.demo.auth.dto.service.request.*;
import gradproj.demo.auth.dto.service.response.*;
import gradproj.demo.auth.repository.AuthQueryRepository;
import gradproj.demo.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final AuthQueryRepository authQueryRepository;
    private final AuthMemberAdapter authMemberAdapter;

    public CResponseLoginDto login(CRequestLoginDto dto) {
        boolean isAuthenticationFailed = authMemberAdapter.isAuthenticationFailed(dto.getLoginId(), dto.getPassword());

        if (isAuthenticationFailed) {
            throw new RuntimeException("login failed");
        }

        String id = dto.loginId;
        String level = authMemberAdapter.getMemberLevel(id);

        authRepository.save(new AuthToken(id, level));
        return new CResponseLoginDto();
    }

    public CResponseLogoutDto logout(CRequestLogoutDto dto) {
        authRepository.deleteByLoginId(dto.getLoginId());
        return new CResponseLogoutDto();
    }

    public CResponseLoginCheckDto loginCheck(CRequestLoginCheckDto dto) {
        boolean b = authRepository.existsByToken(dto.getAuthToken());
        return new CResponseLoginCheckDto(b);
    }

    public CResponseSelfCheckDto selfCheck(CRequestSelfCheckDto dto) {
        return new CResponseSelfCheckDto();
    }

    public CResponseAdminCheckDto adminCheck(CRequestAdminCheckDto dto) {
        String s = authQueryRepository.checkLevel(dto.getAuthToken());
        return new CResponseAdminCheckDto(true);
    }
}
