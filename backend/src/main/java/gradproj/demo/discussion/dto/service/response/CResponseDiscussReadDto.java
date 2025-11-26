package gradproj.demo.discussion.dto.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CResponseDiscussReadDto {
    public String title;
    public String content;
    public String nickname;
    public String time;
}
