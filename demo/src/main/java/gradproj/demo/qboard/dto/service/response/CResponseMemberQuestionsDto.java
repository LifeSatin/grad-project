package gradproj.demo.qboard.dto.service.response;

import gradproj.demo.qboard.dto.QuestionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseMemberQuestionsDto {
    public List<QuestionDto> memberQuestionList;

    public CResponseMemberQuestionsDto(List<QuestionDto> memberQuestionList) {
        this.memberQuestionList = memberQuestionList;
    }
}
