package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestQuestionCreationDto {
    public String title;
    public String content;
    public long memberId;
}
