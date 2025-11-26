package gradproj.demo.discussion.dto.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDiscussReadDto {
    public String title;
    public String content;
    public String nickname;
    public String time;
}
