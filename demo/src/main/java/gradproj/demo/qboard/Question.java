package gradproj.demo.qboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id @GeneratedValue
    private long id;
    private String title;
    private String content;
    private long authorId;
    private String state;

    public Question() {

    }
}
