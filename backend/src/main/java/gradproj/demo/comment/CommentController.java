package gradproj.demo.comment;

import gradproj.demo.comment.dto.controller.request.*;
import gradproj.demo.comment.dto.controller.response.*;
import gradproj.demo.comment.dto.service.request.*;
import gradproj.demo.comment.dto.service.response.CResponseCommentReadDto;
import gradproj.demo.comment.dto.service.response.CResponseMemberCommentsDto;
import org.springframework.web.bind.annotation.*;

/**
 * 구현 상태: 구현 완료
 * 기초 테스트 진행 완료
 */
@CrossOrigin
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 댓글 목록 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param boardId, postId
     * @return List<id, authorId, content>
     */
    @GetMapping("/comments")
    public ResponseCommentReadDto readComment(RequestCommentReadDto dto) {
        CResponseCommentReadDto cdto = commentService.readComments(new CRequestCommentReadDto(dto.getBoardId(), dto.getPostId()));
        return new ResponseCommentReadDto(cdto.getComments());
    }

    /**
     * 회원의 작성 댓글 목록 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param memberId
     * @return List<id, authorId, content>
     */
    @GetMapping("/member/comments")
    public ResponseMemberCommentsDto viewMemberComments(RequestMemberCommentsDto dto) {
        CResponseMemberCommentsDto cdto = commentService.readMemberComments(new CRequestMemberCommentsDto(dto.getMemberId()));
        return new ResponseMemberCommentsDto(cdto.getMemberComments());
    }

    /**
     * 댓글 작성 기능
     * 구현 상턔: 구현 완료
     * 요구 권한: 회원
     * @param content, boardId, postId, authorId
     * @return message
     */
    @PostMapping("/comments/write")
    public ResponseCommentCreationDto createComment(RequestCommentCreationDto dto) {
        commentService.createComment(new CRequestCommentCreationDto(dto.getContent(), dto.getBoardId(), dto.getPostId(), dto.getAuthorId()));
        return new ResponseCommentCreationDto();
    }

    /**
     * 댓글 수정 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인 또는 관리자
     * @param commentId, content
     * @return message
     */
    @PostMapping("/comments/update")
    public ResponseCommentUpdateDto updateComment(RequestCommentUpdateDto dto) {
        commentService.updateComment(new CRequestCommentUpdateDto(dto.getCommentId(), dto.getContent()));
        return new ResponseCommentUpdateDto();
    }

    /**
     * 댓글 삭제 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인 또는 관리자
     * @param commentId
     * @return message
     */
    @PostMapping("/comments/delete")
    public ResponseCommentDeleteDto deleteComment(RequestCommentDeleteDto dto) {
        commentService.deleteComment(new CRequestCommentDeleteDto(dto.getCommentId()));
        return new ResponseCommentDeleteDto();
    }
}
