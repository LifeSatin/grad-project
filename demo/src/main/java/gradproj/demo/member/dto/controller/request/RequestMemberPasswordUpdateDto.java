package gradproj.demo.member.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestMemberPasswordUpdateDto {
    public int memberId;
    public String newPassword;
}
