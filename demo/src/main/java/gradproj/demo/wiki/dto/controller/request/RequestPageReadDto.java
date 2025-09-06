package gradproj.demo.wiki.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestPageReadDto {
    public String pageName;

    public RequestPageReadDto(String pageName) {
        this.pageName = pageName;
    }
}
