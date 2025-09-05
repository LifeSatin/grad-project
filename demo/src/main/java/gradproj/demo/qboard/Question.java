package gradproj.demo.qboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id
    private long id;
}
