package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestQuestionUpdateDto {
    public long postId;
    public String title;
    public String content;

    public CRequestQuestionUpdateDto(long postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }
}
