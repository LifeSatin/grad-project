package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestQuestionReadDto {
    public long postId;

    public RequestQuestionReadDto(long postId) {
        this.postId = postId;
    }
}
