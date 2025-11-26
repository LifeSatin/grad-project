package gradproj.demo.comment;

import gradproj.demo.auth.AuthMemberAdapter;
import gradproj.demo.auth.AuthToken;
import gradproj.demo.auth.repository.AuthRepository;
import gradproj.demo.comment.dto.CommentDto;
import gradproj.demo.comment.dto.ControllerCommentDto;
import gradproj.demo.comment.dto.service.request.*;
import gradproj.demo.comment.dto.service.response.*;
import gradproj.demo.member.Member;
import gradproj.demo.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 구현 완료
 * 기초 테스트 진행 완료
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final CommentQueryRepository commentQueryRepository;
    private final AuthRepository authRepository;

    public CResponseCommentCreationDto createComment(CRequestCommentCreationDto dto) {
        log.info("authorToken: " + dto.getAuthorToken());
        AuthToken token = authRepository.findById(dto.getAuthorToken()).orElseThrow();
        log.info("Id: " + token.getId());
        commentRepository.save(new Comment(dto.getContent(), dto.getBoardId(), dto.getPostId(), token.getId()));
        return new CResponseCommentCreationDto();
    }

    public CResponseCommentReadDto readComments(CRequestCommentReadDto dto) {
        List<CommentDto> comments = commentQueryRepository.getComments(dto.getBoardId(), dto.getPostId());
        ArrayList<ControllerCommentDto> cdtos = new ArrayList<>();
        for (CommentDto comment: comments) {
            log.info("반복문 진입");
            ControllerCommentDto cdto = new ControllerCommentDto();
            cdto.setCommentId(comment.getCommentId());
            cdto.setContent(comment.getContent());
            log.info("아마 여기임");
            Member author = memberRepository.findById(comment.getAuthorId()).orElseThrow();
            cdto.setAuthorId(author.getLoginId());
            cdto.setAuthorNickname(author.getNickname());
            cdtos.add(cdto);
        }
        return new CResponseCommentReadDto(cdtos);
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
