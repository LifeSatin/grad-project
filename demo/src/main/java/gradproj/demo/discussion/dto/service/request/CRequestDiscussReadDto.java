package gradproj.demo.discussion.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestDiscussReadDto {
    public long postId;

    public CRequestDiscussReadDto(long postId) {
        this.postId = postId;
    }
}
