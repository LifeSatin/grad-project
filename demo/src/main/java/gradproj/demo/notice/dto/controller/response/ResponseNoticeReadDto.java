package gradproj.demo.notice.dto.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ResponseNoticeReadDto {
    public String title;
    public String content;
    //public LocalDateTime date;


    public ResponseNoticeReadDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
