package gradproj.demo.qboard.dto.service.response;

import gradproj.demo.qboard.dto.QuestionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseQuestionListDto {
    public List<QuestionDto> questionList;

    public CResponseQuestionListDto(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }
}
