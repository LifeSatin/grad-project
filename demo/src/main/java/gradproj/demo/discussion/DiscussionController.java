package gradproj.demo.discussion;

import gradproj.demo.discussion.dto.controller.request.*;
import gradproj.demo.discussion.dto.controller.response.*;
import gradproj.demo.discussion.dto.service.request.*;
import org.springframework.web.bind.annotation.*;

// 토론 게시판 Controller
@RestController
@RequestMapping("/discuss")
public class DiscussionController {

    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService dBoardService) {
        this.discussionService = dBoardService;
    }

    // 토론 게시판 게시글 목록 조회
    @GetMapping("/board")
    public ResponseDiscussBoardReadDto viewDiscussBoard(RequestDiscussBoardReadDto dto) {
        discussionService.viewDiscussionList(new CRequestDiscussListDto());
        return new ResponseDiscussBoardReadDto();
    }

    // 토론 게시글 작성
    @PostMapping("/board/post")
    public ResponseDiscussCreationDto createDiscussion(RequestDiscussCreationDto dto) {
        discussionService.createDiscussion(new CRequestDiscussCreationDto());
        return new ResponseDiscussCreationDto();
    }

    // 토론 게시글 조회
    @GetMapping("/board/post")
    public ResponseDiscussReadDto readDiscussion(RequestDiscussReadDto dto) {
        discussionService.readDiscussion(new CRequestDiscussReadDto());
        return new ResponseDiscussReadDto();
    }

    // 토론 게시글 수정
    @PatchMapping("/board/post")
    public ResponseDiscussUpdateDto updateDiscussion(RequestDiscussUpdateDto dto) {
        discussionService.updateDiscussion(new CRequestDiscussUpdateDto());
        return new ResponseDiscussUpdateDto();
    }

    // 토론 게시글 삭제
    @DeleteMapping("/board/post")
    public ResponseDiscussDeleteDto deleteDiscussion(RequestDiscussDeleteDto dto) {
        discussionService.deleteDiscussion(new CRequestDiscussDeleteDto());
        return new ResponseDiscussDeleteDto();
    }

    // 토론 게시글 검색
    @GetMapping("/search")
    public ResponseDiscussSearchDto searchDiscussion(RequestDiscussSearchDto dto) {
        discussionService.search(new CRequestDiscussSearchDto());
        return new ResponseDiscussSearchDto();
    }

    // 작성 게시글 목록
    @GetMapping("/member/posts")
    public ResponseMemberDiscussListDto viewMemberPosts(RequestMemberDiscussListDto dto) {
        discussionService.readMemberPosts(new CRequestMemberDiscussDto());
        return new ResponseMemberDiscussListDto();
    }
}
