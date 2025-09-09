package gradproj.demo.discussion.dto.controller.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseMemberDiscussListDto {
    public List<DiscussionDto> memberDiscussion;

    public ResponseMemberDiscussListDto(List<DiscussionDto> memberDiscussion) {
        this.memberDiscussion = memberDiscussion;
    }
}
