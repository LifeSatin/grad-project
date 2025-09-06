package gradproj.demo.discussion;

import gradproj.demo.discussion.dto.controller.request.*;
import gradproj.demo.discussion.dto.controller.response.*;
import gradproj.demo.discussion.dto.service.request.*;
import gradproj.demo.discussion.dto.service.response.CResponseDiscussListDto;
import gradproj.demo.discussion.dto.service.response.CResponseDiscussReadDto;
import gradproj.demo.discussion.dto.service.response.CResponseMemberDiscussDto;
import org.springframework.web.bind.annotation.*;

// 사실상 완료
@RestController
@RequestMapping("/discuss")
public class DiscussionController {

    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService dBoardService) {
        this.discussionService = dBoardService;
    }

    /**
     * 구현 완료
     * @param boardId
     * @return discussList
     */
    @GetMapping("/board")
    public ResponseDiscussListDto viewDiscussBoard(RequestDiscussListDto dto) {
        CResponseDiscussListDto cdto = discussionService.viewDiscussionList(new CRequestDiscussListDto(dto.getBoardId()));
        return new ResponseDiscussListDto(cdto.getDiscussList());
    }

    /**
     * 구현 완료
     * @param title, content, boardId, authorId
     * @return
     */
    @PostMapping("/board/post")
    public ResponseDiscussCreationDto createDiscussion(RequestDiscussCreationDto dto) {
        discussionService.createDiscussion(new CRequestDiscussCreationDto(dto.title, dto.content, dto.boardId, dto.authorId));
        return new ResponseDiscussCreationDto();
    }

    /**
     * author까지 추가하기
     * @param postId
     * @return
     */
    @GetMapping("/board/post")
    public ResponseDiscussReadDto readDiscussion(RequestDiscussReadDto dto) {
        CResponseDiscussReadDto cdto = discussionService.readDiscussion(new CRequestDiscussReadDto(dto.getPostId()));
        return new ResponseDiscussReadDto(cdto.getTitle(), cdto.getContent(), cdto.getAuthorId());
    }

    /**
     * 구현 완료
     * @param postId, title, content
     * @return
     */
    @PatchMapping("/board/post")
    public ResponseDiscussUpdateDto updateDiscussion(RequestDiscussUpdateDto dto) {
        discussionService.updateDiscussion(new CRequestDiscussUpdateDto(dto.getPostId(), dto.getTitle(), dto.getContent()));
        return new ResponseDiscussUpdateDto();
    }

    /**
     * 구현 완료
     * @param postId
     * @return
     */
    @DeleteMapping("/board/post")
    public ResponseDiscussDeleteDto deleteDiscussion(RequestDiscussDeleteDto dto) {
        discussionService.deleteDiscussion(new CRequestDiscussDeleteDto(dto.getPostId()));
        return new ResponseDiscussDeleteDto();
    }

    /**
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public ResponseDiscussSearchDto searchDiscussion(RequestDiscussSearchDto dto) {
        discussionService.search(new CRequestDiscussSearchDto());
        return new ResponseDiscussSearchDto();
    }

    /**
     * 구현 완료
     * @param memberId
     * @return
     */
    @GetMapping("/member/posts")
    public ResponseMemberDiscussListDto viewMemberPosts(RequestMemberDiscussListDto dto) {
        CResponseMemberDiscussDto cdto = discussionService.readMemberPosts(new CRequestMemberDiscussDto(dto.getMemberId()));
        return new ResponseMemberDiscussListDto(cdto.getMemberDiscussions());
    }
}
