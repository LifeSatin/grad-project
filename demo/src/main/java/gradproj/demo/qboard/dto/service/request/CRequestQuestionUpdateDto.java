package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestQuestionUpdateDto {
    public long postId;
    public String title;
    public String content;
}
