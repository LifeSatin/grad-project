package gradproj.demo.discussion;

import gradproj.demo.discussion.dto.controller.request.*;
import gradproj.demo.discussion.dto.controller.response.*;
import gradproj.demo.discussion.dto.service.request.*;
import gradproj.demo.discussion.dto.service.response.CResponseDiscussListDto;
import gradproj.demo.discussion.dto.service.response.CResponseDiscussReadDto;
import gradproj.demo.discussion.dto.service.response.CResponseMemberDiscussDto;
import org.springframework.web.bind.annotation.*;

/**
 * 구현 완료
 * 기초 테스트 진행 완료
 */
@CrossOrigin
@RestController
@RequestMapping("/discuss")
public class DiscussionController {

    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService dBoardService) {
        this.discussionService = dBoardService;
    }

    /**
     * 토론 게시판의 게시글 목록 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param boardId
     * @return discussList
     */
    @GetMapping("/board")
    public ResponseDiscussListDto viewDiscussBoard(RequestDiscussListDto dto) {
        CResponseDiscussListDto cdto = discussionService.viewDiscussionList(new CRequestDiscussListDto(dto.getBoardId()));
        return new ResponseDiscussListDto(cdto.getBoardName(), cdto.getDiscussList());
    }

    /**
     * 토론 게시판의 게시글 검색 기능
     * 구현 상태: 미구현
     * 요구 권한: 없음
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public ResponseDiscussSearchDto searchDiscussion(RequestDiscussSearchDto dto) {
        discussionService.search(new CRequestDiscussSearchDto());
        return new ResponseDiscussSearchDto();
    }

    /**
     * 회원의 작성 토론 게시글 검색 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param memberId
     * @return
     */
    @GetMapping("/member/posts")
    public ResponseMemberDiscussListDto viewMemberPosts(RequestMemberDiscussListDto dto) {
        CResponseMemberDiscussDto cdto = discussionService.readMemberPosts(new CRequestMemberDiscussDto(dto.getMemberId()));
        return new ResponseMemberDiscussListDto(cdto.getMemberDiscussions());
    }

    /**
     * 토론 게시판의 게시글 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param postId
     * @return title, content, authorId
     */
    @GetMapping("/board/post")
    public ResponseDiscussReadDto readDiscussion(RequestDiscussReadDto dto) {
        CResponseDiscussReadDto cdto = discussionService.readDiscussion(new CRequestDiscussReadDto(dto.getPostId()));
        return new ResponseDiscussReadDto(cdto.getTitle(), cdto.getContent(), cdto.getAuthorId());
    }

    /**
     * 토론 게시판의 게시글 작성 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 회원
     * @param title, content, boardId, authorId
     * @return
     */
    @PostMapping("/write")
    public ResponseDiscussCreationDto createDiscussion(RequestDiscussCreationDto dto) {
        discussionService.createDiscussion(new CRequestDiscussCreationDto(dto.title, dto.content, dto.boardId, dto.authorId));
        return new ResponseDiscussCreationDto();
    }

    /**
     * 토론 게시판의 게시글 수정 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인 또는 관리자
     * @param postId, title, content
     * @return
     */
    @PostMapping("/update")
    public ResponseDiscussUpdateDto updateDiscussion(RequestDiscussUpdateDto dto) {
        discussionService.updateDiscussion(new CRequestDiscussUpdateDto(dto.getPostId(), dto.getTitle(), dto.getContent()));
        return new ResponseDiscussUpdateDto();
    }

    /**
     * 토론 게시판의 게시글 삭제 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인 또는 관리자
     * @param postId
     * @return
     */
    @PostMapping("/delete")
    public ResponseDiscussDeleteDto deleteDiscussion(RequestDiscussDeleteDto dto) {
        discussionService.deleteDiscussion(new CRequestDiscussDeleteDto(dto.getPostId()));
        return new ResponseDiscussDeleteDto();
    }
}
