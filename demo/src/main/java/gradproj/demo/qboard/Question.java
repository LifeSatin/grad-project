package gradproj.demo.qboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Question {
    @Id @GeneratedValue
    private long id;
    @Getter
    private String title;
    @Getter
    private String content;
    @Getter
    private long authorId;
    @Getter
    private String state;

    public Question() {

    }

    public Question(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public Question(String title, String content, long authorId, String state) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.state = state;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
