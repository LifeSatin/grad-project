package gradproj.demo.qboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionBoardDto {
    public long id;
    public String title;
    public long authorId;
    public String time;
}
