package gradproj.demo.wiki;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Page {
    @Id @Getter
    private String pageName;
    @Getter
    private String content;

    public Page() {

    }

    public Page(String pageName) {
        this.pageName = pageName;
    }

    public void update(String content) {
        this.content = content;
    }
}
