package gradproj.demo.discussion.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestDiscussDeleteDto {
    public long postId;

    public CRequestDiscussDeleteDto(long postId) {
        this.postId = postId;
    }
}
