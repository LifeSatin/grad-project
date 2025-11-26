package gradproj.demo.discussion.dto.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CRequestDiscussCreationDto {
    public String title;
    public String content;
    public String time;
    public long boardId;
    public String authorToken;
}
