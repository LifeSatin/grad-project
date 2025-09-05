package gradproj.demo.member;

import gradproj.demo.member.dto.CRequestLoginDto;
import gradproj.demo.member.dto.CRequestMemberCreationDto;
import gradproj.demo.member.dto.CRequestMemberNicknameUpdateDto;
import gradproj.demo.member.dto.CRequestMemberPasswordUpdateDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(CRequestMemberCreationDto dto) {
        memberRepository.save(new Member());
    }

    public void readMemberInfo(long memberId) {
        memberRepository.findById(memberId);
    }

    public void updateMemberNickname(CRequestMemberNicknameUpdateDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.memberId);
        Member member = byId.orElseThrow();
        // 후추
    }

    public void updateMemberPassword(CRequestMemberPasswordUpdateDto dto) {
        Optional<Member> byId = memberRepository.findById(dto.memberId);
        Member member = byId.orElseThrow();
        // 후추
    }

    public void deleteMember(long memberId) {
        memberRepository.deleteById(memberId);
    }

    public void login(CRequestLoginDto dto) {
        // 후추
    }

    public void readMemberBookmarks(long memberId) {
        Optional<Member> byId = memberRepository.findById(memberId);
        Member member = byId.orElseThrow();
        // 후추
    }

    public void updateMemberBookmarks(long memberId) {
        Optional<Member> byId = memberRepository.findById(memberId);
        Member member = byId.orElseThrow();
        // 후추
    }
}
