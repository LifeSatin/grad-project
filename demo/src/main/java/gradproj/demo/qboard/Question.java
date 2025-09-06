package gradproj.demo.qboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id @GeneratedValue
    private long id;

    public Question() {

    }
}
