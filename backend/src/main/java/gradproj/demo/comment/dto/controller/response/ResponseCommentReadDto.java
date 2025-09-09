package gradproj.demo.comment.dto.controller.response;

import gradproj.demo.comment.dto.CommentDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseCommentReadDto {
    public List<CommentDto> comments;

    public ResponseCommentReadDto(List<CommentDto> comments) {
        this.comments = comments;
    }
}
