package gradproj.demo.comment.dto.controller.response;

import gradproj.demo.comment.dto.CommentDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseMemberCommentsDto {
    public List<CommentDto> memberComments;

    public ResponseMemberCommentsDto(List<CommentDto> memberComments) {
        this.memberComments = memberComments;
    }
}
