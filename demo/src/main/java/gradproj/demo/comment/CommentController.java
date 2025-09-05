package gradproj.demo.comment;

import gradproj.demo.comment.dto.*;
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
    public ResponseCommentReadDto readComment(@RequestParam long postId) {
        commentService.readComments(postId);
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
    public ResponseCommentDeleteDto deleteComment(@RequestParam int postId) {
        commentService.deleteComment(postId);
        return new ResponseCommentDeleteDto();
    }

    // 작성 댓글 목록
    @GetMapping("/member/comments")
    public ResponseCommentReadDto viewMemberComments(int memberId) {
        commentService.readMemberComments(memberId);
        return new ResponseCommentReadDto();
    }
}
