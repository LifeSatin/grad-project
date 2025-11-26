package gradproj.demo.discussion.dto.service.response;

import gradproj.demo.discussion.dto.DiscussionDto;
import gradproj.demo.discussion.dto.DiscussionListDto;
import gradproj.demo.discussion.dto.DiscussionListProcessedDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseDiscussListDto {
    public String boardName;
    public List<DiscussionListProcessedDto> discussList;

    public CResponseDiscussListDto(String boardName, List<DiscussionListProcessedDto> discussList) {
        this.boardName = boardName;
        this.discussList = discussList;
    }
}
