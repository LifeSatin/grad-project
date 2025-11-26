package gradproj.demo.discussion.dto.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

// 토론 게시판 게시글 생성용 DTO
@Getter
@AllArgsConstructor
public class RequestDiscussCreationDto {
    public String title;
    public String content;
    public String time;
    public long boardId;
    public String authorToken;
}
