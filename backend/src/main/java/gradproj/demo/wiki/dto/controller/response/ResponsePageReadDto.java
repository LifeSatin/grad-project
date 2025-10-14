package gradproj.demo.wiki.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponsePageReadDto {
    public int status = 200;
    public String pageName;
    public String content;

    public ResponsePageReadDto(String pageName, String content) {
        this.pageName = pageName;
        this.content = content;
    }
}
