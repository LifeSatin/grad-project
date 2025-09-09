package gradproj.demo.discussion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiscussionDto {
    public long id;
    public String title;
    public long authorId;
}
