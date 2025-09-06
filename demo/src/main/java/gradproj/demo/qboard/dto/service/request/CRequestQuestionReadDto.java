package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestQuestionReadDto {
    public long postId;

    public CRequestQuestionReadDto(long postId) {
        this.postId = postId;
    }
}
