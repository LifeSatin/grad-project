package gradproj.demo.notice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Notice {
    @Id @GeneratedValue
    public long id;

    public Notice() {

    }
}
