package gradproj.demo.qboard.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponseQuestionCreationDto {
    public int status = 200;
    public long postId;
    public String message = "success";

    public ResponseQuestionCreationDto(long postId) {
        this.postId = postId;
    }
}
