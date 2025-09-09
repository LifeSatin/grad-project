package gradproj.demo.wiki.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestPageCreationDto {
    public String pageName;

    public CRequestPageCreationDto(String pageName) {
        this.pageName = pageName;
    }
}
