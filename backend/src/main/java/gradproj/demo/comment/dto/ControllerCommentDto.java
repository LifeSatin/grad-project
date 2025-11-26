package gradproj.demo.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ControllerCommentDto {
    public long commentId;
    public String authorId;
    public String content;
    public String authorNickname;
}
