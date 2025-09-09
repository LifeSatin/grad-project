package gradproj.demo.comment;

import gradproj.demo.comment.dto.CommentDto;
import gradproj.demo.comment.dto.service.request.*;
import gradproj.demo.comment.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 구현 완료
 * 기초 테스트 진행 완료
 */
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentQueryRepository commentQueryRepository;

    public CommentService(CommentRepository commentRepository, CommentQueryRepository commentQueryRepository) {
        this.commentRepository = commentRepository;
        this.commentQueryRepository = commentQueryRepository;
    }

    public CResponseCommentCreationDto createComment(CRequestCommentCreationDto dto) {
        commentRepository.save(new Comment(dto.getContent(), dto.getBoardId(), dto.getPostId(), dto.getAuthorId()));
        return new CResponseCommentCreationDto();
    }

    public CResponseCommentReadDto readComments(CRequestCommentReadDto dto) {
        List<CommentDto> comments = commentQueryRepository.getComments(dto.getBoardId(), dto.getPostId());
        return new CResponseCommentReadDto(comments);
    }

    public CResponseCommentUpdateDto updateComment(CRequestCommentUpdateDto dto) {
        Optional<Comment> byId = commentRepository.findById(dto.getCommentId());
        Comment comment = byId.orElseThrow();
        comment.update(dto.getContent());
        commentRepository.save(comment);
        return new CResponseCommentUpdateDto();
    }

    public CResponseCommentDeleteDto deleteComment(CRequestCommentDeleteDto dto) {
        commentRepository.deleteById(dto.getCommentId());
        return new CResponseCommentDeleteDto();
    }

    public CResponseMemberCommentsDto readMemberComments(CRequestMemberCommentsDto dto) {
        List<CommentDto> memberComments = commentQueryRepository.getMemberComments(dto.getMemberId());
        return new CResponseMemberCommentsDto(memberComments);
    }
}
