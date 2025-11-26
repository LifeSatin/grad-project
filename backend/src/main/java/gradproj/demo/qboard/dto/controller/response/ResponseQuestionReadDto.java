package gradproj.demo.qboard.dto.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseQuestionReadDto {
    public String title;
    public String content;
    public String nickname;
    public String time;
    public String fileId;
    public String fileName;
}
