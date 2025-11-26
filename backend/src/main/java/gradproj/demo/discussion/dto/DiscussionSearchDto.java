package gradproj.demo.discussion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscussionSearchDto {
    public long id;
    public long boardId;
    public String title;
}
