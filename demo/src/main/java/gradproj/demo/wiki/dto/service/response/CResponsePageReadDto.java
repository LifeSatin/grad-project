package gradproj.demo.wiki.dto.service.response;

import lombok.Getter;

@Getter
public class CResponsePageReadDto {
    public String pageName;
    public String content;

    public CResponsePageReadDto(String pageName, String content) {
        this.pageName = pageName;
        this.content = content;
    }
}
