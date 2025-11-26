package gradproj.demo.qboard.dto.service.response;

import gradproj.demo.qboard.dto.QuestionDto;
import gradproj.demo.qboard.dto.QuestionListDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseQuestionListDto {
    public List<QuestionListDto> questionList;

    public CResponseQuestionListDto(List<QuestionListDto> questionList) {
        this.questionList = questionList;
    }
}
