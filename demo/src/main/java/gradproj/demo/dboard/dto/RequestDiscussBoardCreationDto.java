package gradproj.demo.dboard.dto;

import lombok.Getter;

// 토론 게시판 생성용 DTO
@Getter
public class RequestDiscussBoardCreationDto {
    public int originalPostId;
    public String boardName;
}
