package gradproj.demo.wiki.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestPageCreationDto {
    public String pageName;

    public RequestPageCreationDto(String pageName) {
        this.pageName = pageName;
    }
}
