package gradproj.demo.wiki.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestPageReadDto {
    public String pageName;

    public CRequestPageReadDto(String pageName) {
        this.pageName = pageName;
    }
}
