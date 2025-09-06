package gradproj.demo.comment;

import gradproj.demo.comment.dto.controller.request.*;
import gradproj.demo.comment.dto.controller.response.*;
import gradproj.demo.comment.dto.service.request.*;
import gradproj.demo.comment.dto.service.response.CResponseCommentReadDto;
import gradproj.demo.comment.dto.service.response.CResponseMemberCommentsDto;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 구현 완료
     * @param content, postId, authorId
     * @return
     */
    @PostMapping("/comments")
    public ResponseCommentCreationDto createComment(RequestCommentCreationDto dto) {
        commentService.createComment(new CRequestCommentCreationDto(dto.getContent(), dto.getPostId(), dto.getAuthorId()));
        return new ResponseCommentCreationDto();
    }

    /**
     * 구현 완료
     * @param postId
     * @return List<authorId, content>
     */
    @GetMapping("/comments")
    public ResponseCommentReadDto readComment(RequestCommentReadDto dto) {
        CResponseCommentReadDto cdto = commentService.readComments(new CRequestCommentReadDto(dto.getPostId()));
        return new ResponseCommentReadDto(cdto.getComments());
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param commentId, content
     * @return message
     */
    @PatchMapping("/comments")
    public ResponseCommentUpdateDto updateComment(RequestCommentUpdateDto dto) {
        commentService.updateComment(new CRequestCommentUpdateDto(dto.getCommentId(), dto.getContent()));
        return new ResponseCommentUpdateDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param commentId
     * @return message
     */
    @DeleteMapping("/comments")
    public ResponseCommentDeleteDto deleteComment(RequestCommentDeleteDto dto) {
        commentService.deleteComment(new CRequestCommentDeleteDto(dto.getCommentId()));
        return new ResponseCommentDeleteDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param memberId
     * @return List<authorId, content>
     */
    @GetMapping("/member/comments")
    public ResponseMemberCommentsDto viewMemberComments(RequestMemberCommentsDto dto) {
        CResponseMemberCommentsDto cdto = commentService.readMemberComments(new CRequestMemberCommentsDto(dto.getMemberId()));
        return new ResponseMemberCommentsDto(cdto.getMemberComments());
    }
}
