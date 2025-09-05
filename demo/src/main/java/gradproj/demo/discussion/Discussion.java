package gradproj.demo.discussion;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Discussion {

    @Id
    private Long id;

    private String title;

    private String content;
}
