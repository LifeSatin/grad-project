package gradproj.demo.comment.dto.service.response;

import gradproj.demo.comment.dto.CommentDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseMemberCommentsDto {
    public List<CommentDto> memberComments;

    public CResponseMemberCommentsDto(List<CommentDto> memberComments) {
        this.memberComments = memberComments;
    }
}
