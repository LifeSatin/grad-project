package gradproj.demo.discussion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Discussion {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;

    public Discussion() {

    }
}
