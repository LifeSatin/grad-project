package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestDiscussDeleteDto {
    public long postId;

    public RequestDiscussDeleteDto(long postId) {
        this.postId = postId;
    }
}
