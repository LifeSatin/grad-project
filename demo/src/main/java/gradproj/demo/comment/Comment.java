package gradproj.demo.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id @GeneratedValue
    private long id;
    private String content;
    private long postId;
    private long authorId;

    public Comment() {

    }

    public Comment(String content, long postId, long authorId) {
        this.content = content;
        this.postId = postId;
        this.authorId = authorId;
    }

    public void update(String content) {
        this.content = content;
    }
}
