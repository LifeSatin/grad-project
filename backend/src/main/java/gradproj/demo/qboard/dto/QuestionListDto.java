package gradproj.demo.qboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionListDto {
    public long id;
    public String title;
    public String time;
    public String nickname;
}
