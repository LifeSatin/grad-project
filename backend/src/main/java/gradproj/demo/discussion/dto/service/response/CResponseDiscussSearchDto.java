package gradproj.demo.discussion.dto.service.response;

import gradproj.demo.discussion.DiscussionService;
import gradproj.demo.discussion.dto.DiscussionDto;
import gradproj.demo.discussion.dto.DiscussionSearchDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseDiscussSearchDto {
    List<DiscussionSearchDto> discussionList;

    public CResponseDiscussSearchDto(List<DiscussionSearchDto> discussionList) {
        this.discussionList = discussionList;
    }
}
