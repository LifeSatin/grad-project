package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestQuestionUpdateDto {
    public int postId;
    public String title;
    public String content;

    public RequestQuestionUpdateDto(int postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }
}
