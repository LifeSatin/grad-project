package gradproj.demo.qboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
    public long postId;
    public String title;
    public long authorId;

    public QuestionDto(long postId, String title, long authorId) {
        this.postId = postId;
        this.title = title;
        this.authorId = authorId;
    }
}
