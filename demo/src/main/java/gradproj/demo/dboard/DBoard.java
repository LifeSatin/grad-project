package gradproj.demo.dboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DBoard {
    @Id @GeneratedValue
    private long id;

    public DBoard() {

    }
}
