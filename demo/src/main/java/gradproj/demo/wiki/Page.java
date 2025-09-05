package gradproj.demo.wiki;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Page {
    @Id
    private long id;
}
