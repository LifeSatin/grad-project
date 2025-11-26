package gradproj.demo.qboard.dto.controller.response;

import gradproj.demo.qboard.dto.QuestionDto;
import gradproj.demo.qboard.dto.QuestionListDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseQuestionListDto {
    public List<QuestionListDto> questionList;

    public ResponseQuestionListDto(List<QuestionListDto> questionList) {
        this.questionList = questionList;
    }
}
