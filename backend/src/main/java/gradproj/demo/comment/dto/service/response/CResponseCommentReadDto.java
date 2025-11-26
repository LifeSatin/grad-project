package gradproj.demo.comment.dto.service.response;

import gradproj.demo.comment.dto.CommentDto;
import gradproj.demo.comment.dto.ControllerCommentDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseCommentReadDto {
    public List<ControllerCommentDto> comments;

    public CResponseCommentReadDto(List<ControllerCommentDto> comments) {
        this.comments = comments;
    }
}
