package gradproj.demo.member.dto;

import lombok.Getter;

@Getter
public class RequestMemberPasswordUpdateDto {
    public int memberId;
    public String newPassword;
}
