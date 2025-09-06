package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

// 토론 게시판 게시글 수정용 DTO
@Getter
public class RequestDiscussUpdateDto {
    public int postId;
    public String title;
    public String content;
}
