package gradproj.demo.wiki.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestPageDeleteDto {
    public String pageName;

    public RequestPageDeleteDto(String pageName) {
        this.pageName = pageName;
    }
}
