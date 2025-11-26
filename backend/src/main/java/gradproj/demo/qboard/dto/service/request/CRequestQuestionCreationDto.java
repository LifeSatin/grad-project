package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestQuestionCreationDto {
    public String title;
    public String content;
    public String authorToken;
    public String time;
    public String fileId;
    public String fileName;

    public CRequestQuestionCreationDto(String title, String content, String authorToken, String time, String fileId, String fileName) {
        this.title = title;
        this.content = content;
        this.authorToken = authorToken;
        this.time = time;
        this.fileId = fileId;
        this.fileName = fileName;
    }
}
