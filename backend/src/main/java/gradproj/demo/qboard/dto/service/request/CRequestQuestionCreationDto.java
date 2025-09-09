package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestQuestionCreationDto {
    public String title;
    public String content;
    public long memberId;

    public CRequestQuestionCreationDto(String title, String content, long memberId) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }
}
