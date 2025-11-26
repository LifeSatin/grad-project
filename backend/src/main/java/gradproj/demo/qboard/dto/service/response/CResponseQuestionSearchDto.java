package gradproj.demo.qboard.dto.service.response;

import gradproj.demo.qboard.dto.QuestionDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CResponseQuestionSearchDto {
    public List<QuestionDto> questionList;

    public CResponseQuestionSearchDto(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }
}
