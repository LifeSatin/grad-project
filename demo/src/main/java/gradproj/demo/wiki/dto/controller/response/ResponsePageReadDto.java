package gradproj.demo.wiki.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponsePageReadDto {
    public String pageName;
    public String content;

    public ResponsePageReadDto(String pageName, String content) {
        this.pageName = pageName;
        this.content = content;
    }
}
