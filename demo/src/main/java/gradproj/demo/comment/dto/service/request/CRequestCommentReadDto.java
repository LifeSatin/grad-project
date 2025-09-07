package gradproj.demo.comment.dto.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CRequestCommentReadDto {
    public long boardId;
    public long postId;
}
