package gradproj.demo.discussion.dto.service.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseDiscussListDto {
    public List<DiscussionDto> discussList;

    public CResponseDiscussListDto(List<DiscussionDto> discussList) {
        this.discussList = discussList;
    }
}
