package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestQuestionSearchDto {
    public String keyword;

    public RequestQuestionSearchDto(String keyword) {
        this.keyword = keyword;
    }
}
