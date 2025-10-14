package gradproj.demo.auth;

import gradproj.demo.auth.dto.service.request.*;
import gradproj.demo.auth.dto.service.response.*;
import gradproj.demo.auth.repository.AuthQueryRepository;
import gradproj.demo.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final AuthQueryRepository authQueryRepository;
    private final AuthMemberAdapter authMemberAdapter;

    public CResponseLoginDto login(CRequestLoginDto dto) {
        log.info("[AuthService:login] id: " + dto.getLoginId() + ", password: " + dto.getPassword());
        if (authMemberAdapter.simpleLoginMethod(dto.getLoginId()) == null) {
            throw new RuntimeException("login failed");
        }
        boolean isAuthenticationSucceeded = authMemberAdapter.simpleLoginMethod(dto.getLoginId()).equals(dto.getPassword());
        log.info("isAuthenticationSucceeded: " + isAuthenticationSucceeded);

        if (!isAuthenticationSucceeded) {
            throw new RuntimeException("login failed");
        }

        String id = dto.loginId;
        String level = authMemberAdapter.getMemberLevel(id);

        log.info("[AuthService:login] id: " + id + ", level: " + level);
        String token = String.valueOf(UUID.randomUUID());
        authRepository.save(new AuthToken(String.valueOf(token), id, level));
        return new CResponseLoginDto(token);
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
