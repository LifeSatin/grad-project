package gradproj.demo.notice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
public class Notice {
    @Id @GeneratedValue
    public long id;
    @Getter
    public String title;
    @Getter
    public String content;
    @Getter
    public LocalDateTime date;

    public Notice() {

    }

    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Notice(String title, String content, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
