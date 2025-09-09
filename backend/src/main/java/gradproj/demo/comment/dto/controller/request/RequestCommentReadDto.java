package gradproj.demo.comment.dto.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestCommentReadDto {
    public long boardId;
    public long postId;
}
