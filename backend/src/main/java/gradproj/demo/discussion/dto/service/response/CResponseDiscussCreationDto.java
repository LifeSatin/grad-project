package gradproj.demo.discussion.dto.service.response;

import lombok.Getter;

@Getter
public class CResponseDiscussCreationDto {
    public long postId;
    public String message = "success";

    public CResponseDiscussCreationDto(long postId) {
        this.postId = postId;
    }
}
