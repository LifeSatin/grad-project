package gradproj.demo.wiki.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponsePageCreationDto {
    public int status = 200;
    public String message = "success";

    public ResponsePageCreationDto() {
    }
}
