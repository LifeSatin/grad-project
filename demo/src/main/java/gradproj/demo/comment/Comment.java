package gradproj.demo.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id @GeneratedValue
    private long id;

    public Comment() {

    }
}
