package gradproj.demo.comment;

import gradproj.demo.comment.dto.CRequestCommentCreationDto;
import gradproj.demo.comment.dto.CRequestCommentUpdateDto;
import gradproj.demo.comment.dto.CResponseCommentReadDto;
import gradproj.demo.comment.dto.CResponseMemberCommentsDto;
import gradproj.demo.member.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(CRequestCommentCreationDto dto) {
        commentRepository.save(new Comment());
    }

    public CResponseCommentReadDto readComments(long postId) {
        Optional<Comment> byId = commentRepository.findById(postId);
        Comment comment = byId.orElseThrow();
        //후추
        return new CResponseCommentReadDto();
    }

    public void updateComment(CRequestCommentUpdateDto dto) {
        Optional<Comment> byId = commentRepository.findById(dto.postId);
        Comment comment = byId.orElseThrow();
        //후추
    }

    public void deleteComment(long postId) {
        commentRepository.deleteById(postId);
    }

    public CResponseMemberCommentsDto readMemberComments(long memberId) {
        Optional<Comment> byId = commentRepository.findById(memberId);
        // 후추
        return new CResponseMemberCommentsDto();
    }
}
