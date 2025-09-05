package gradproj.demo.wiki.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestPageUpdateDto {
    public String pageName;
    public String content;
    public LocalDateTime date;
}
