package gradproj.demo.qboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Question {
    @Id @GeneratedValue
    private long id;
    private String title;
    private String content;
    private long authorId;
    private String state;
    private String time;
    private String fileId;
    private String fileName;

    public Question() {

    }

    public Question(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public Question(String title, String content, long authorId, String time, String fileId, String fileName) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.time = time;
        this.fileId = fileId;
        this.fileName = fileName;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
