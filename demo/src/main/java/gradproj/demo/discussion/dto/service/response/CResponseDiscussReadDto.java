package gradproj.demo.discussion.dto.service.response;

import lombok.Getter;

@Getter
public class CResponseDiscussReadDto {
    public String title;
    public String content;
    public long authorId;

    public CResponseDiscussReadDto(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
}
