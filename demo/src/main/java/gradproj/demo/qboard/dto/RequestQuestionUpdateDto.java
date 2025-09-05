package gradproj.demo.qboard.dto;

import lombok.Getter;

@Getter
public class RequestQuestionUpdateDto {
    public int postId;
    public String title;
    public String content;
}
