package gradproj.demo.qboard.dto.service.response;

import lombok.Getter;

@Getter
public class CResponseQuestionCreationDto {
    public long postId;
    public String message = "success";

    public CResponseQuestionCreationDto(long postId) {
        this.postId = postId;
    }
}
