package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestQuestionUpdateDto {
    public int postId;
    public String title;
    public String content;
}
