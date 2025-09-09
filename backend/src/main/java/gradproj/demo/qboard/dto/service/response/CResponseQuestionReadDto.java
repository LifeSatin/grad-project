package gradproj.demo.qboard.dto.service.response;

import lombok.Getter;

@Getter
public class CResponseQuestionReadDto {
    public String title;
    public String content;
    public long authorId;

    public CResponseQuestionReadDto(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
}
