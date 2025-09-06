package gradproj.demo.discussion;

import gradproj.demo.discussion.dto.service.request.*;
import gradproj.demo.discussion.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionService(DiscussionRepository dBoardRepository) {
        this.discussionRepository = dBoardRepository;
    }

    public CResponseDiscussListDto viewDiscussionList(CRequestDiscussListDto dto) {
        List<Discussion> all = discussionRepository.findAll();
        // 후추
        return new CResponseDiscussListDto();
    }

    public CResponseDiscussCreationDto createDiscussion(CRequestDiscussCreationDto dto) {
        discussionRepository.save(new Discussion());
        return new CResponseDiscussCreationDto();
    }

    public CResponseDiscussReadDto readDiscussion(CRequestDiscussReadDto dto) {
        Optional<Discussion> byId = discussionRepository.findById(dto.getPostId());
        Discussion discussion = byId.orElseThrow();
        return new CResponseDiscussReadDto();
    }

    public CResponseDiscussUpdateDto updateDiscussion(CRequestDiscussUpdateDto dto) {
        Optional<Discussion> byId = discussionRepository.findById(dto.postId);
        Discussion discussion = byId.orElseThrow();
        // 후추
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
        // 후추
        return new CResponseMemberDiscussDto();
    }
}
