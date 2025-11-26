package gradproj.demo.discussion.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestDiscussSearchDto {
    public String keyword;

    public CRequestDiscussSearchDto(String keyword) {
        this.keyword = keyword;
    }
}
