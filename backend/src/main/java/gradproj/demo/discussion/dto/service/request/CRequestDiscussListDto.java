package gradproj.demo.discussion.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestDiscussListDto {
    public long boardId;

    public CRequestDiscussListDto(long boardId) {
        this.boardId = boardId;
    }
}
