package gradproj.demo.discussion;

import gradproj.demo.discussion.dto.DiscussionDto;
import gradproj.demo.discussion.dto.service.request.*;
import gradproj.demo.discussion.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 구현 완료
 */
@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;
    private final DiscussionQueryRepository discussionQueryRepository;

    public DiscussionService(DiscussionRepository discussionRepository, DiscussionQueryRepository discussionQueryRepository) {
        this.discussionRepository = discussionRepository;
        this.discussionQueryRepository = discussionQueryRepository;
    }

    public CResponseDiscussListDto viewDiscussionList(CRequestDiscussListDto dto) {
        List<DiscussionDto> all = discussionQueryRepository.getDiscussionList(dto.getBoardId());
        return new CResponseDiscussListDto(all);
    }

    public CResponseDiscussCreationDto createDiscussion(CRequestDiscussCreationDto dto) {
        discussionRepository.save(new Discussion(dto.getTitle(), dto.getContent(), dto.getBoardId(), dto.getAuthorId()));
        return new CResponseDiscussCreationDto();
    }

    public CResponseDiscussReadDto readDiscussion(CRequestDiscussReadDto dto) {
        Optional<Discussion> byId = discussionRepository.findById(dto.getPostId());
        Discussion discussion = byId.orElseThrow();
        return new CResponseDiscussReadDto(discussion.getTitle(), discussion.getContent(), discussion.getAuthorId());
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
        return new CResponseDiscussSearchDto();
    }

    public CResponseMemberDiscussDto readMemberPosts(CRequestMemberDiscussDto dto) {
        List<DiscussionDto> memberDiscussionList = discussionQueryRepository.getMemberDiscussionList(dto.getMemberId());
        return new CResponseMemberDiscussDto(memberDiscussionList);
    }
}