package gradproj.demo.discussion.dto.service.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseMemberDiscussDto {
    public List<DiscussionDto> memberDiscussions;

    public CResponseMemberDiscussDto(List<DiscussionDto> memberDiscussions) {
        this.memberDiscussions = memberDiscussions;
    }
}
