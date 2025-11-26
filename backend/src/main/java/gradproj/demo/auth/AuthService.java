package gradproj.demo.auth;

import gradproj.demo.auth.dto.service.request.*;
import gradproj.demo.auth.dto.service.response.*;
import gradproj.demo.auth.repository.AuthQueryRepository;
import gradproj.demo.auth.repository.AuthRepository;
import gradproj.demo.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final AuthQueryRepository authQueryRepository;
    private final AuthMemberAdapter authMemberAdapter;
    private final MemberRepository memberRepository;

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

        String id = dto.getLoginId();
        long memberId = authMemberAdapter.getMemberId(id);
        String level = authMemberAdapter.getMemberLevel(id);

        String token = String.valueOf(UUID.randomUUID());
        authRepository.save(new AuthToken(String.valueOf(token), memberId, level));
        return new CResponseLoginDto(token);
    }

    public CResponseLogoutDto logout(CRequestLogoutDto dto) {
        authRepository.deleteById(dto.getToken());
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

    public CResponseUserDto getUser(CRequestUserDto dto) {
        AuthToken token = null;
        try {
            token = authRepository.findById(dto.getToken()).orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return new CResponseUserDto(400, "not a user");
        }
        return new CResponseUserDto(200, memberRepository.findById(token.getId()).orElseThrow().getNickname());
    }
}
