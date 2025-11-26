package gradproj.demo.qboard.dto.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CResponseQuestionReadDto {
    public String title;
    public String content;
    public String nickname;
    public String time;
    public String fileId;
    public String fileName;

}
