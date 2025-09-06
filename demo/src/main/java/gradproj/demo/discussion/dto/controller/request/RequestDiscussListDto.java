package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestDiscussListDto {
    public long boardId;

    public RequestDiscussListDto(long boardId) {
        this.boardId = boardId;
    }
}
