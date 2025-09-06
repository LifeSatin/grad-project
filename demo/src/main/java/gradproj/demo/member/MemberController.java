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

    /**
     * 구현 완료
     * @param dto
     * @return
     */
    @PostMapping("/member")
    public ResponseMemberCreationDto createMember(RequestMemberCreationDto dto) {
        CRequestMemberCreationDto cdto = new CRequestMemberCreationDto(dto.getId(), dto.getPassword(), dto.getNickname());
        memberService.createMember(cdto);
        return new ResponseMemberCreationDto();
    }

    /**
     * 구현 완료
     * @param dto
     * @return
     */
    @GetMapping("/member")
    public ResponseMemberReadDto readMember(RequestMemberReadDto dto) {
        CResponseMemberReadDto cdto = memberService.readMemberInfo(new CRequestMemberReadDto(dto.getMemberId()));
        return new ResponseMemberReadDto(cdto.getId(), cdto.getNickname(), cdto.getPower());
    }

    /**
     * 구현 완료
     * @param dto
     * @return
     */
    @PatchMapping("/member/nickname")
    public ResponseMemberNicknameUpdateDto editMemberNickname(RequestMemberNicknameUpdateDto dto) {
        memberService.updateMemberNickname(new CRequestMemberNicknameUpdateDto(dto.getMemberId(), dto.getNewNickname()));
        return new ResponseMemberNicknameUpdateDto();
    }

    /**
     * 구현 완료
     * @param dto
     * @return
     */
    @PatchMapping("/member/password")
    public ResponseMemberPasswordUpdateDto editMemberPassword(RequestMemberPasswordUpdateDto dto) {
        memberService.updateMemberPassword(new CRequestMemberPasswordUpdateDto(dto.getMemberId(), dto.getNewPassword()));
        return new ResponseMemberPasswordUpdateDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param dto
     * @return
     */
    @DeleteMapping("/member")
    public ResponseMemberDeleteDto deleteMember(RequestMemberDeleteDto dto) {
        memberService.deleteMember(new CRequestMemberDeleteDto(dto.getMemberId()));
        return new ResponseMemberDeleteDto();
    }

    /**
     *
     * @param dto
     * @return
     */
    @GetMapping("/member/bookmark")
    public ResponseMemberBookmarkReadDto readMemberBookmarks(RequestMemberBookmarkReadDto dto) {
        memberService.readMemberBookmarks(new CRequestMemberBookmarkReadDto(dto.getMemberId()));
        return new ResponseMemberBookmarkReadDto();
    }

    /**
     *
     * @param dto
     * @return
     */
    @PutMapping("/member/bookmark")
    public ResponseMemberBookmarkUpdateDto updateMemberBookmarks(RequestMemberBookmarkUpdateDto dto) {
        memberService.updateMemberBookmarks(new CRequestMemberBookmarkUpdateDto(dto.getMemberId()));
        return new ResponseMemberBookmarkUpdateDto();
    }
}
