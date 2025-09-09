package gradproj.demo.discussion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Discussion {

    @Id @GeneratedValue
    private long id;
    @Getter
    private String title;
    @Getter
    private String content;
    private long boardId;
    @Getter
    private long authorId;

    public Discussion() {

    }

    public Discussion(String title, String content, long boardId, long authorId) {
        this.title = title;
        this.content = content;
        this.boardId = boardId;
        this.authorId = authorId;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
