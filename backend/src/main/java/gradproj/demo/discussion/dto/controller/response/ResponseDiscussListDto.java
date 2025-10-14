package gradproj.demo.discussion.dto.controller.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseDiscussListDto {
    public String boardName;
    public List<DiscussionDto> discussList;

    public ResponseDiscussListDto(String boardName, List<DiscussionDto> discussList) {
        this.boardName = boardName;
        this.discussList = discussList;
    }
}
