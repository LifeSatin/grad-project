package gradproj.demo.member.dto.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMemberPasswordUpdateDto {
    public long memberId;
    public String newPassword;

    public RequestMemberPasswordUpdateDto(long memberId, String newPassword) {
        this.memberId = memberId;
        this.newPassword = newPassword;
    }
}
