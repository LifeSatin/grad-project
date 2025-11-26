package gradproj.demo.discussion.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionListDto {
    public long id;
    public String title;
    public long authorId;
    public String time;
}
