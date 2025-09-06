package gradproj.demo.member;

import gradproj.demo.member.dto.controller.request.*;
import gradproj.demo.member.dto.controller.response.*;
import gradproj.demo.member.dto.service.request.*;
import gradproj.demo.member.dto.service.response.CResponseMemberReadDto;
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
        CRequestMemberCreationDto cdto = new CRequestMemberCreationDto(dto.getId(), dto.getPassword(), dto.getNickname());
        memberService.createMember(cdto);
        return new ResponseMemberCreationDto();
    }

    // 회원 정보 조회
    @GetMapping("/member")
    public ResponseMemberReadDto readMember(RequestMemberReadDto dto) {
        CResponseMemberReadDto cdto = memberService.readMemberInfo(new CRequestMemberReadDto(dto.getMemberId()));
        return new ResponseMemberReadDto(cdto.getId(), cdto.getNickname(), cdto.getPower());
    }

    // 회원 닉네임 수정
    @PatchMapping("/member/nickname")
    public ResponseMemberNicknameUpdateDto editMemberNickname(RequestMemberNicknameUpdateDto dto) {
        memberService.updateMemberNickname(new CRequestMemberNicknameUpdateDto(dto.getMemberId(), dto.getNewNickname()));
        return new ResponseMemberNicknameUpdateDto();
    }

    // 비밀번호 수정
    @PatchMapping("/member/password")
    public ResponseMemberPasswordUpdateDto editMemberPassword(RequestMemberPasswordUpdateDto dto) {
        memberService.updateMemberPassword(new CRequestMemberPasswordUpdateDto(dto.getMemberId(), dto.getNewPassword()));
        return new ResponseMemberPasswordUpdateDto();
    }

    // 회원 탈퇴
    @DeleteMapping("/member")
    public ResponseMemberDeleteDto deleteMapping(RequestMemberDeleteDto dto) {
        memberService.deleteMember(new CRequestMemberDeleteDto(dto.getMemberId()));
        return new ResponseMemberDeleteDto();
    }

    // 즐겨찾기 게시판 목록 조회
    @GetMapping("/member/bookmark")
    public ResponseMemberBookmarkReadDto readMemberBookmarks(RequestMemberBookmarkReadDto dto) {
        memberService.readMemberBookmarks(new CRequestMemberBookmarkReadDto(dto.getMemberId()));
        return new ResponseMemberBookmarkReadDto();
    }

    // 즐겨찾기 게시판 항목 수정
    @PutMapping("/member/bookmark")
    public ResponseMemberBookmarkUpdateDto updateMemberBookmarks(RequestMemberBookmarkUpdateDto dto) {
        memberService.updateMemberBookmarks(new CRequestMemberBookmarkUpdateDto(dto.getMemberId()));
        return new ResponseMemberBookmarkUpdateDto();
    }
}
