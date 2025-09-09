package gradproj.demo.qboard.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberQuestionsDto {
    public long memberId;

    public CRequestMemberQuestionsDto(long memberId) {
        this.memberId = memberId;
    }
}
