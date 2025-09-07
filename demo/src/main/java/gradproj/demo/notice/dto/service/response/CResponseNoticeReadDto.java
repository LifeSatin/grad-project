package gradproj.demo.notice.dto.service.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CResponseNoticeReadDto {
    public String title = "unexisting post";
    public String content = "this post doesn't exist.";
    //public LocalDateTime date;

    public CResponseNoticeReadDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
