package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestDiscussReadDto {
    public long postId;

    public RequestDiscussReadDto(long postId) {
        this.postId = postId;
    }
}
