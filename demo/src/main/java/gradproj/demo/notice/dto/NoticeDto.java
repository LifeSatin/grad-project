package gradproj.demo.notice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDto {
    public long id;
    public String title;

    public NoticeDto(long id, String title) {
        this.id = id;
        this.title = title;
    }
}
