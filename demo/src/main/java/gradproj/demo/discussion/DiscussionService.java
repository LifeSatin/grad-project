package gradproj.demo.discussion;

import gradproj.demo.discussion.dto.*;
import gradproj.demo.member.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionService(DiscussionRepository dBoardRepository) {
        this.discussionRepository = dBoardRepository;
    }

    public void viewDiscussionList(long boardId) {
        List<Discussion> all = discussionRepository.findAll();
        // 후추
    }

    public void createDiscussion(CRequestDiscussCreationDto dto) {
        discussionRepository.save(new Discussion());
    }

    public CResponseDiscussReadDto readDiscussion(long postId) {
        Optional<Discussion> byId = discussionRepository.findById(postId);
        Discussion discussion = byId.orElseThrow();
        return new CResponseDiscussReadDto();
    }

    public void updateDiscussion(CRequestDiscussUpdateDto dto) {
        Optional<Discussion> byId = discussionRepository.findById(dto.postId);
        Discussion discussion = byId.orElseThrow();
        // 후추
    }

    public void deleteDiscussion(long postId) {
        discussionRepository.deleteById(postId);
    }

    public void search(String keyword) {

    }

    public void readMemberPosts(long memberId) {
        // 후추
    }
}
