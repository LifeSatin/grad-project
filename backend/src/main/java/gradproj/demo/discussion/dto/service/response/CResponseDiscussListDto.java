package gradproj.demo.discussion.dto.service.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseDiscussListDto {
    public String boardName;
    public List<DiscussionDto> discussList;

    public CResponseDiscussListDto(String boardName, List<DiscussionDto> discussList) {
        this.boardName = boardName;
        this.discussList = discussList;
    }
}
