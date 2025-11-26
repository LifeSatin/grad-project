package gradproj.demo.comment.dto.controller.response;

import gradproj.demo.comment.dto.CommentDto;
import gradproj.demo.comment.dto.ControllerCommentDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseCommentReadDto {
    public List<ControllerCommentDto> comments;

    public ResponseCommentReadDto(List<ControllerCommentDto> comments) {
        this.comments = comments;
    }
}
