package gradproj.demo.wiki.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestPageSearchDto {
    public String keyword;

    public RequestPageSearchDto(String keyword) {
        this.keyword = keyword;
    }
}
