package gradproj.demo.notice.dto.service.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CRequestNoticeCreationDto {
    public String title;
    public String content;
    public LocalDateTime date;

    public CRequestNoticeCreationDto(String title, String content, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
