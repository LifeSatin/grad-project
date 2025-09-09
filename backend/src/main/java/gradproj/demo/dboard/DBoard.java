package gradproj.demo.dboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DBoard {
    @Id @GeneratedValue
    private long id;
    private String name;
    //private long postId;

    public DBoard() {

    }

    public DBoard(String name) {
        this.name = name;
    }
}
