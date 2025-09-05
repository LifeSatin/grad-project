package gradproj.demo.notice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestNoticeCreationDto {
    public String title;
    public String content;
    public LocalDateTime date;
}
