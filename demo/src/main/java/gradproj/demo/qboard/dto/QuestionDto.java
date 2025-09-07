package gradproj.demo.qboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDto {
    public long id;
    public String title;
    public long authorId;
}
