package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestQuestionSearchDto {
    public String keyword;

    public CRequestQuestionSearchDto(String keyword) {
        this.keyword = keyword;
    }
}
