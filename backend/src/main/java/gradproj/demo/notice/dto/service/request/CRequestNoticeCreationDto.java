package gradproj.demo.notice.dto.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CRequestNoticeCreationDto {
    public String title;
    public String content;
    //public LocalDateTime date;
}
