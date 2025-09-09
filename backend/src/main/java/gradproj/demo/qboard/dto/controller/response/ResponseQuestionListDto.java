package gradproj.demo.qboard.dto.controller.response;

import gradproj.demo.qboard.dto.QuestionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseQuestionListDto {
    public List<QuestionDto> questionList;

    public ResponseQuestionListDto(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }
}
