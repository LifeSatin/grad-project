package gradproj.demo.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Comment {
    @Id @GeneratedValue
    private long id;
    private String content;
    @Getter
    private long boardId;
    @Getter
    private long postId;
    @Getter
    private long authorId;

    public Comment() {

    }

    public Comment(String content, long boardId, long postId, long authorId) {
        this.content = content;
        this.boardId = boardId;
        this.postId = postId;
        this.authorId = authorId;
    }

    public void update(String content) {
        this.content = content;
    }
}
