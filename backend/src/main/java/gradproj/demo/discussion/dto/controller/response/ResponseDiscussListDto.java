package gradproj.demo.discussion.dto.controller.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseDiscussListDto {
    public List<DiscussionDto> discussList;

    public ResponseDiscussListDto(List<DiscussionDto> discussList) {
        this.discussList = discussList;
    }
}
