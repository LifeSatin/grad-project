package gradproj.demo.wiki;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Page {
    @Id @GeneratedValue
    private long id;

    public Page() {

    }
}
