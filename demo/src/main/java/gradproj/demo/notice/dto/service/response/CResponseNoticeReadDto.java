package gradproj.demo.notice.dto.service.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CResponseNoticeReadDto {
    public String title;
    public String content;
    //public LocalDateTime date;

    public CResponseNoticeReadDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
