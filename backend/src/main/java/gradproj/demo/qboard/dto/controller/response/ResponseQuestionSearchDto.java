package gradproj.demo.qboard.dto.controller.response;

import gradproj.demo.qboard.dto.QuestionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseQuestionSearchDto {
    public List<QuestionDto> questionList;

    public ResponseQuestionSearchDto(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }
}
