package gradproj.demo.qboard.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestMemberQuestionsDto {
    public long memberId;

    public RequestMemberQuestionsDto(long memberId) {
        this.memberId = memberId;
    }
}
