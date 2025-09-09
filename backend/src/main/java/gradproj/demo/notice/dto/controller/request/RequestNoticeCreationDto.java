package gradproj.demo.notice.dto.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class RequestNoticeCreationDto {
    public String title;
    public String content;
    //public LocalDateTime date;
}
