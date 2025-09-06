package gradproj.demo.discussion.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestDiscussCreationDto {
    public String title;
    public String content;
    public long boardId;
    public long authorId;

    public CRequestDiscussCreationDto(String title, String content, long boardId, long authorId) {
        this.title = title;
        this.content = content;
        this.boardId = boardId;
        this.authorId = authorId;
    }
}
