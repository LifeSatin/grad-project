package gradproj.demo.dboard.dto;

import lombok.Getter;

// 토론 게시판 생성용 DTO
@Getter
public class RequestDiscussBoardCreationDto {
    public long originalPostId;
    public String boardName;

    public RequestDiscussBoardCreationDto(long originalPostId, String boardName) {
        this.originalPostId = originalPostId;
        this.boardName = boardName;
    }
}
