package gradproj.demo.member;

import gradproj.demo.auth.AuthToken;
import gradproj.demo.auth.repository.AuthRepository;
import gradproj.demo.member.dto.service.request.*;
import gradproj.demo.member.dto.service.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthRepository authRepository;

    // 회원 가입
    public CResponseMemberCreationDto createMember(CRequestMemberCreationDto dto) {
        memberRepository.save(new Member(dto.getId(), dto.getPassword(), dto.getNickname()));
        return new CResponseMemberCreationDto();
    }

    public CResponseMemberReadDto readMemberInfo(CRequestMemberReadDto dto) {
        AuthToken token = authRepository.findById(dto.getToken()).orElseThrow();
        long userId = token.getId();
        Member member = memberRepository.findById(userId).orElseThrow();
        return new CResponseMemberReadDto(member.getId(), member.getLoginId(), member.getNickname(), member.getPower());
    }

    public CResponseMemberNicknameUpdateDto updateMemberNickname(CRequestMemberNicknameUpdateDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.getMemberId());
        Member member = byId.orElseThrow();
        member.changeNickname(dto.getNickname());
        memberRepository.save(member);
        return new CResponseMemberNicknameUpdateDto();
    }

    public CResponseMemberPasswordUpdateDto updateMemberPassword(CRequestMemberPasswordUpdateDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.getMemberId());
        Member member = byId.orElseThrow();
        member.changePassword(dto.getPassword());
        memberRepository.save(member);
        return new CResponseMemberPasswordUpdateDto();
    }

    public CResponseMemberDeleteDto deleteMember(CRequestMemberDeleteDto dto) {
        memberRepository.deleteById(dto.getMemberId());
        return new CResponseMemberDeleteDto();
    }

    public CResponseMemberBookmarkReadDto readMemberBookmarks(CRequestMemberBookmarkReadDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.getMemberId());
        Member member = byId.orElseThrow();
        // 후추
        return new CResponseMemberBookmarkReadDto();
    }

    public CResponseMemberBookmarkUpdateDto updateMemberBookmarks(CRequestMemberBookmarkUpdateDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.getMemberId());
        Member member = byId.orElseThrow();
        // 후추
        return new CResponseMemberBookmarkUpdateDto();
    }
}
