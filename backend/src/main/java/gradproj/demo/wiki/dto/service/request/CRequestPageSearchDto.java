package gradproj.demo.wiki.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestPageSearchDto {
    public String keyword;

    public CRequestPageSearchDto(String keyword) {
        this.keyword = keyword;
    }
}
