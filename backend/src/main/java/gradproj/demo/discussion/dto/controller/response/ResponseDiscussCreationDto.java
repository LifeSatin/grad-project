package gradproj.demo.discussion.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponseDiscussCreationDto {
    public int status = 200;
    public long postId;
    public String message = "success";

    public ResponseDiscussCreationDto(long postId) {
        this.postId = postId;
    }
}
