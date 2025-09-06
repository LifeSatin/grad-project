package gradproj.demo.comment.dto.service.response;

import gradproj.demo.comment.dto.CommentDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseCommentReadDto {
    public List<CommentDto> comments;

    public CResponseCommentReadDto(List<CommentDto> comments) {
        this.comments = comments;
    }
}
