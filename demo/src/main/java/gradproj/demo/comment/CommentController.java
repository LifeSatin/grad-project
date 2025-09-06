package gradproj.demo.comment;

import gradproj.demo.comment.dto.controller.request.*;
import gradproj.demo.comment.dto.controller.response.*;
import gradproj.demo.comment.dto.service.request.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 작성
    @PostMapping("/comments")
    public ResponseCommentCreationDto createComment(RequestCommentCreationDto dto) {
        commentService.createComment(new CRequestCommentCreationDto());
        return new ResponseCommentCreationDto();
    }

    // 댓글 조회
    @RequestMapping("/comments")
    public ResponseCommentReadDto readComment(RequestCommentReadDto dto) {
        commentService.readComments(new CRequestCommentReadDto());
        return new ResponseCommentReadDto();
    }

    // 댓글 수정
    @PatchMapping("/comments")
    public ResponseCommentUpdateDto updateComment(RequestCommentUpdateDto dto) {
        commentService.updateComment(new CRequestCommentUpdateDto());
        return new ResponseCommentUpdateDto();
    }

    // 댓글 삭제
    @DeleteMapping("/comments")
    public ResponseCommentDeleteDto deleteComment(RequestCommentDeleteDto dto) {
        commentService.deleteComment(new CRequestCommentDeleteDto());
        return new ResponseCommentDeleteDto();
    }

    // 작성 댓글 목록
    @GetMapping("/member/comments")
    public ResponseMemberCommentsDto viewMemberComments(RequestMemberCommentsDto dto) {
        commentService.readMemberComments(new CRequestMemberCommentsDto());
        return new ResponseMemberCommentsDto();
    }
}
