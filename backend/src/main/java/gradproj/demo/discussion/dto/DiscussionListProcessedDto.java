package gradproj.demo.discussion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiscussionListProcessedDto {
    public long id;
    public String title;
    public String nickname;
    public String time;
}
