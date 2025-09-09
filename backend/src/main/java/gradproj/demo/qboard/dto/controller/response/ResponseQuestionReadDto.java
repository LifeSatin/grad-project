package gradproj.demo.qboard.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponseQuestionReadDto {
    public String title;
    public String content;
    public long authorId;

    public ResponseQuestionReadDto(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
}
