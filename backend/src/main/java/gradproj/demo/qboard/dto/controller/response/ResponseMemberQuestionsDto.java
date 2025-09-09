package gradproj.demo.qboard.dto.controller.response;

import gradproj.demo.qboard.dto.QuestionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseMemberQuestionsDto {
    public List<QuestionDto> memberQuestionList;

    public ResponseMemberQuestionsDto(List<QuestionDto> memberQuestionList) {
        this.memberQuestionList = memberQuestionList;
    }
}
