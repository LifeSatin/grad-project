package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
public class RequestQuestionCreationDto {
    public String authorToken;
    public String title;
    public String content;
    public String time;
    public MultipartFile file;

    public RequestQuestionCreationDto(String authorToken, String title, String content, String time, MultipartFile file) {
        this.authorToken = authorToken;
        this.title = title;
        this.content = content;
        this.time = time;
        this.file = file;
    }
}
