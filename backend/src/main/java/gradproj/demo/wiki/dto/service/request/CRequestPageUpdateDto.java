package gradproj.demo.wiki.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestPageUpdateDto {
    public String pageName;
    public String content;

    public CRequestPageUpdateDto(String pageName, String content) {
        this.pageName = pageName;
        this.content = content;
    }
}
