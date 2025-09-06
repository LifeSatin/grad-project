package gradproj.demo.comment;

import gradproj.demo.comment.dto.service.request.*;
import gradproj.demo.comment.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CResponseCommentCreationDto createComment(CRequestCommentCreationDto dto) {
        commentRepository.save(new Comment());
        return new CResponseCommentCreationDto();
    }

    public CResponseCommentReadDto readComments(CRequestCommentReadDto dto) {
        Optional<Comment> byId = commentRepository.findById(dto.getPostId());
        Comment comment = byId.orElseThrow();
        //후추
        return new CResponseCommentReadDto();
    }

    public CResponseCommentUpdateDto updateComment(CRequestCommentUpdateDto dto) {
        Optional<Comment> byId = commentRepository.findById(dto.postId);
        Comment comment = byId.orElseThrow();
        //후추
        return new CResponseCommentUpdateDto();
    }

    public CResponseCommentDeleteDto deleteComment(CRequestCommentDeleteDto dto) {
        commentRepository.deleteById(dto.getPostId());
        return new CResponseCommentDeleteDto();
    }

    public CResponseMemberCommentsDto readMemberComments(CRequestMemberCommentsDto dto) {
        Optional<Comment> byId = commentRepository.findById(dto.getMemberId());
        // 후추
        return new CResponseMemberCommentsDto();
    }
}
