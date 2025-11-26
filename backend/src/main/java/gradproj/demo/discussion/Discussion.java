package gradproj.demo.discussion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Discussion {

    @Id @GeneratedValue
    private long id;
    private String title;
    private String content;
    private String time;
    private long boardId;
    private long authorId;

    public Discussion() {

    }

    public Discussion(String title, String content, String time, long boardId, long authorId) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.boardId = boardId;
        this.authorId = authorId;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
