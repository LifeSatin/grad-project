package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestDiscussSearchDto {
    public String keyword;

    public RequestDiscussSearchDto(String keyword) {
        this.keyword = keyword;
    }
}
