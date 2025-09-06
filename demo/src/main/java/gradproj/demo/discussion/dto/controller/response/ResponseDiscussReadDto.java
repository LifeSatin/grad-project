package gradproj.demo.discussion.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponseDiscussReadDto {
    public String title;
    public String content;
    public long authorId;

    public ResponseDiscussReadDto(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
}
