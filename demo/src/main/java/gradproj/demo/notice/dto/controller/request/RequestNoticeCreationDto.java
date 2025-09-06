package gradproj.demo.notice.dto.controller.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestNoticeCreationDto {
    public String title;
    public String content;
    public LocalDateTime date;

    public RequestNoticeCreationDto(String title, String content, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
