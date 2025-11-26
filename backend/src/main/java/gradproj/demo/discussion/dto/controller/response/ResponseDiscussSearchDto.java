package gradproj.demo.discussion.dto.controller.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import gradproj.demo.discussion.dto.DiscussionSearchDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseDiscussSearchDto {
    public List<DiscussionSearchDto> discussionList;

    public ResponseDiscussSearchDto(List<DiscussionSearchDto> discussionList) {
        this.discussionList = discussionList;
    }
}
