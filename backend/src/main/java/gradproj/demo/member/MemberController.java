package gradproj.demo.member;

import gradproj.demo.auth.AuthService;
import gradproj.demo.member.dto.controller.request.*;
import gradproj.demo.member.dto.controller.response.*;
import gradproj.demo.member.dto.service.request.*;
import gradproj.demo.member.dto.service.response.CResponseMemberReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 미구현 2개 (북마크 조회, 북마크 수정) 제외 구현 완료
 * 기초 테스트 진행 완료
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param id, password, nickname
     * @return message
     */
    @PostMapping("/register")
    public ResponseMemberCreationDto createMember(RequestMemberCreationDto dto) {
        CRequestMemberCreationDto cdto = new CRequestMemberCreationDto(dto.getId(), dto.getPassword(), dto.getNickname());
        memberService.createMember(cdto);
        return new ResponseMemberCreationDto();
    }

    /**
     * 회원 정보 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인
     * @param memberId
     * @return id, nickname, power
     */
    @GetMapping("/member")
    public ResponseMemberReadDto readMember(RequestMemberReadDto dto) {

        CResponseMemberReadDto cdto = memberService.readMemberInfo(new CRequestMemberReadDto(dto.getToken()));
        return new ResponseMemberReadDto(cdto.getId(), cdto.getLoginId(), cdto.getNickname(), cdto.getPower());
    }

    /**
     * 회원 닉네임 수정 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인
     * @param memberId, newNickname
     * @return message
     */
    @PatchMapping("/member/nickname")
    public ResponseMemberNicknameUpdateDto editMemberNickname(RequestMemberNicknameUpdateDto dto) {
        memberService.updateMemberNickname(new CRequestMemberNicknameUpdateDto(dto.getMemberId(), dto.getNewNickname()));
        return new ResponseMemberNicknameUpdateDto();
    }

    /**
     * 회원 비밀번호 수정 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인
     * @param memberId, newPassword
     * @return message
     */
    @PatchMapping("/member/password")
    public ResponseMemberPasswordUpdateDto editMemberPassword(RequestMemberPasswordUpdateDto dto) {
        memberService.updateMemberPassword(new CRequestMemberPasswordUpdateDto(dto.getMemberId(), dto.getNewPassword()));
        return new ResponseMemberPasswordUpdateDto();
    }

    /**
     * 회원 즐겨찾기 게시판 목록 조회 기능
     * 구현 상태: 미구현
     * 요구 권한: 본인
     * @param dto
     * @return
     */
    @GetMapping("/member/bookmark")
    public ResponseMemberBookmarkReadDto readMemberBookmarks(RequestMemberBookmarkReadDto dto) {
        memberService.readMemberBookmarks(new CRequestMemberBookmarkReadDto(dto.getMemberId()));
        return new ResponseMemberBookmarkReadDto();
    }

    /**
     * 회원 즐겨찾기 게시판 목록 수정 기능
     * 구현 상태: 미구현
     * 요구 권한: 본인
     * @param dto
     * @return
     */
    @PutMapping("/member/bookmark")
    public ResponseMemberBookmarkUpdateDto updateMemberBookmarks(RequestMemberBookmarkUpdateDto dto) {
        memberService.updateMemberBookmarks(new CRequestMemberBookmarkUpdateDto(dto.getMemberId()));
        return new ResponseMemberBookmarkUpdateDto();
    }

    /**
     * 회원 탈퇴 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인 혹은 관리자
     * @param memberId
     * @return message
     */
    @DeleteMapping("/member/withdraw")
    public ResponseMemberDeleteDto deleteMember(RequestMemberDeleteDto dto) {
        memberService.deleteMember(new CRequestMemberDeleteDto(dto.getMemberId()));
        return new ResponseMemberDeleteDto();
    }
}
