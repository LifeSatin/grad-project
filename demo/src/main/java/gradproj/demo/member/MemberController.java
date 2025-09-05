package gradproj.demo.member;

import gradproj.demo.member.dto.*;
import org.springframework.web.bind.annotation.*;

// 회원 관련 기능 Controller
@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping("/member")
    public ResponseMemberCreationDto createMember(RequestMemberCreationDto dto) {
        memberService.createMember(new CRequestMemberCreationDto());
        return new ResponseMemberCreationDto();
    }

    // 회원 정보 조회
    @GetMapping("/member")
    public ResponseMemberReadDto readMember(long memberId) {
        memberService.readMemberInfo(memberId);
        return new ResponseMemberReadDto();
    }

    // 회원 닉네임 수정
    @PatchMapping("/member/nickname")
    public ResponseMemberNicknameUpdateDto editMemberNickname(RequestMemberNicknameUpdateDto dto) {
        memberService.updateMemberNickname(new CRequestMemberNicknameUpdateDto());
        return new ResponseMemberNicknameUpdateDto();
    }

    // 비밀번호 수정
    @PatchMapping("/member/password")
    public ResponseMemberPasswordUpdateDto editMemberPassword(RequestMemberPasswordUpdateDto dto) {
        memberService.updateMemberPassword(new CRequestMemberPasswordUpdateDto());
        return new ResponseMemberPasswordUpdateDto();
    }

    // 회원 탈퇴
    @DeleteMapping("/member")
    public ResponseMemberDeleteDto deleteMapping(long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseMemberDeleteDto();
    }

    // 로그인
    @GetMapping("/login")
    public ResponseLoginDto login(RequestLoginDto dto) {
        memberService.login(new CRequestLoginDto());
        return new ResponseLoginDto();
    }

    // 즐겨찾기 게시판 목록 조회
    @GetMapping("/member/bookmark")
    public ResponseMemberBookmarkReadDto readMemberBookmarks(long memberId) {
        memberService.readMemberBookmarks(memberId);
        return new ResponseMemberBookmarkReadDto();
    }

    // 즐겨찾기 게시판 항목 수정
    @PutMapping("/member/bookmark")
    public ResponseMemberBookmarkUpdateDto updateMemberBookmarks(long memberId) {
        memberService.updateMemberBookmarks(memberId);
        return new ResponseMemberBookmarkUpdateDto();
    }
}
