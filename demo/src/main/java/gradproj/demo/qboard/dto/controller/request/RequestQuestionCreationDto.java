package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestQuestionCreationDto {
    public int authorId;
    public String title;
    public String content;
    public LocalDateTime date;
}
