package gradproj.demo.wiki.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestPageDeleteDto {
    public String pageName;

    public CRequestPageDeleteDto(String pageName) {
        this.pageName = pageName;
    }
}
