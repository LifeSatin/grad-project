package gradproj.demo.member;

import gradproj.demo.member.dto.service.request.*;
import gradproj.demo.member.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public CResponseMemberCreationDto createMember(CRequestMemberCreationDto dto) {
        memberRepository.save(new Member(dto.getId(), dto.getPassword(), dto.getNickname()));
        return new CResponseMemberCreationDto();
    }

    public CResponseMemberReadDto readMemberInfo(CRequestMemberReadDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.getMemberId());
        Member member = byId.orElseThrow();
        return new CResponseMemberReadDto(member.getLoginId(), member.getNickname(), member.getPower());
    }

    public CResponseMemberNicknameUpdateDto updateMemberNickname(CRequestMemberNicknameUpdateDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.getMemberId());
        Member member = byId.orElseThrow();
        // 후추
        return new CResponseMemberNicknameUpdateDto();
    }

    public CResponseMemberPasswordUpdateDto updateMemberPassword(CRequestMemberPasswordUpdateDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.memberId);
        Member member = byId.orElseThrow();
        // 후추
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
