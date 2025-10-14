package gradproj.demo.member.dto.controller.response;

import lombok.Getter;

@Getter
public class ResponseMemberCreationDto {
    public int status = 200;
    public String message = "완료";

    public ResponseMemberCreationDto() {
    }
}
