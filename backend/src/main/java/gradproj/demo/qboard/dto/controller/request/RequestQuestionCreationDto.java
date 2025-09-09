package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestQuestionCreationDto {
    public int authorId;
    public String title;
    public String content;
    //public LocalDateTime date;


    public RequestQuestionCreationDto(int authorId, String title, String content) {
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }
}
