package gradproj.demo.discussion;

import gradproj.demo.auth.AuthToken;
import gradproj.demo.auth.repository.AuthRepository;
import gradproj.demo.dboard.DBoard;
import gradproj.demo.dboard.DBoardQueryRepository;
import gradproj.demo.dboard.DBoardRepository;
import gradproj.demo.discussion.dto.DiscussionDto;
import gradproj.demo.discussion.dto.DiscussionListDto;
import gradproj.demo.discussion.dto.DiscussionListProcessedDto;
import gradproj.demo.discussion.dto.DiscussionSearchDto;
import gradproj.demo.discussion.dto.service.request.*;
import gradproj.demo.discussion.dto.service.response.*;
import gradproj.demo.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 구현 완료
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DiscussionService {

    private final DiscussionRepository discussionRepository;
    private final DiscussionQueryRepository discussionQueryRepository;
    private final DBoardRepository dBoardRepository;
    private final AuthRepository authRepository;
    private final MemberRepository memberRepository;

    public CResponseDiscussListDto viewDiscussionList(CRequestDiscussListDto dto) {
        DBoard dBoard = dBoardRepository.findById(dto.getBoardId()).orElseThrow();
        String boardName = dBoard.getName();
        List<DiscussionListDto> all = discussionQueryRepository.getDiscussionList(dto.getBoardId());
        List<DiscussionListProcessedDto> result = all.stream().map(k -> new DiscussionListProcessedDto(k.getId(), k.getTitle(), memberRepository.findById(k.getAuthorId()).orElseThrow().getNickname(), k.getTime())).toList();
        return new CResponseDiscussListDto(boardName, result);
    }

    public CResponseDiscussCreationDto createDiscussion(CRequestDiscussCreationDto dto) {
        log.info(dto.toString());
        AuthToken token = authRepository.findById(dto.getAuthorToken()).orElseThrow();
        long authorId = token.getId();
        Discussion save = discussionRepository.save(new Discussion(dto.getTitle(), dto.getContent(), dto.getTime(), dto.getBoardId(), authorId));
        return new CResponseDiscussCreationDto(save.getId());
    }

    public CResponseDiscussReadDto readDiscussion(CRequestDiscussReadDto dto) {
        Discussion discussion = discussionRepository.findById(dto.getPostId()).orElseThrow();
        log.info(discussion.getTitle());
        return new CResponseDiscussReadDto(discussion.getTitle(), discussion.getContent(), memberRepository.findById(discussion.getAuthorId()).orElseThrow().getNickname(), discussion.getTime());
    }

    public CResponseDiscussUpdateDto updateDiscussion(CRequestDiscussUpdateDto dto) {
        Optional<Discussion> byId = discussionRepository.findById(dto.postId);
        Discussion discussion = byId.orElseThrow();
        discussion.update(dto.getTitle(), dto.getContent());
        discussionRepository.save(discussion);
        return new CResponseDiscussUpdateDto();
    }

    public CResponseDiscussDeleteDto deleteDiscussion(CRequestDiscussDeleteDto dto) {
        discussionRepository.deleteById(dto.getPostId());
        return new CResponseDiscussDeleteDto();
    }

    public CResponseDiscussSearchDto search(CRequestDiscussSearchDto dto) {
        List<DiscussionSearchDto> result = discussionQueryRepository.searchDiscussion(dto.getKeyword());
        return new CResponseDiscussSearchDto(result);
    }

    public CResponseMemberDiscussDto readMemberPosts(CRequestMemberDiscussDto dto) {
        List<DiscussionDto> memberDiscussionList = discussionQueryRepository.getMemberDiscussionList(dto.getMemberId());
        return new CResponseMemberDiscussDto(memberDiscussionList);
    }
}