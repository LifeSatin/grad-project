package gradproj.demo.qboard;

import gradproj.demo.qboard.dto.QuestionDto;
import gradproj.demo.qboard.dto.service.request.*;
import gradproj.demo.qboard.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QBoardService {

    private final QBoardRepository qBoardRepository;
    private final QBoardQueryRepository qBoardQueryRepository;

    public QBoardService(QBoardRepository qBoardRepository, QBoardQueryRepository qBoardQueryRepository) {
        this.qBoardRepository = qBoardRepository;
        this.qBoardQueryRepository = qBoardQueryRepository;
    }

    public CResponseQuestionCreationDto createQuestion(CRequestQuestionCreationDto dto) {
        qBoardRepository.save(new Question(dto.getTitle(), dto.getContent(), dto.getMemberId()));
        return new CResponseQuestionCreationDto();
    }

    public CResponseQuestionReadDto readQuestion(CRequestQuestionReadDto dto) {
        Optional<Question> byId = qBoardRepository.findById(dto.getPostId());
        Question question = byId.orElseThrow();
        return new CResponseQuestionReadDto(question.getTitle(), question.getContent(), question.getAuthorId());
    }

    public CResponseQuestionUpdateDto updateQuestion(CRequestQuestionUpdateDto dto) {
        Optional<Question> byId = qBoardRepository.findById(dto.getPostId());
        Question question = byId.orElseThrow();
        question.update(dto.getTitle(), dto.getContent());
        qBoardRepository.save(question);
        return new CResponseQuestionUpdateDto();
    }

    public CResponseQuestionSearchDto search(CRequestQuestionSearchDto dto) {
        return new CResponseQuestionSearchDto();
    }

    public CResponseQuestionListDto viewQuestionList() {
        List<QuestionDto> questionList = qBoardQueryRepository.getQuestionList();
        return new CResponseQuestionListDto(questionList);
    }

    public CResponseMemberQuestionsDto readMemberPosts(CRequestMemberQuestionsDto dto) {
        List<QuestionDto> memberQuestionList = qBoardQueryRepository.getMemberQuestionList(dto.getMemberId());
        return new CResponseMemberQuestionsDto(memberQuestionList);
    }
}
