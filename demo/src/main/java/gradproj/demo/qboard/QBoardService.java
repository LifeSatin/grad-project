package gradproj.demo.qboard;

import gradproj.demo.qboard.dto.service.request.*;
import gradproj.demo.qboard.dto.service.response.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QBoardService {

    private final QBoardRepository qBoardRepository;

    public QBoardService(QBoardRepository qBoardRepository) {
        this.qBoardRepository = qBoardRepository;
    }

    public CResponseQuestionCreationDto createQuestion(CRequestQuestionCreationDto dto) {
        qBoardRepository.save(new Question());
        return new CResponseQuestionCreationDto();
    }

    public CResponseQuestionReadDto readQuestion(CRequestQuestionReadDto dto) {
        qBoardRepository.findById(dto.getPostId());
        return new CResponseQuestionReadDto();
    }

    public CResponseQuestionUpdateDto updateQuestion(CRequestQuestionUpdateDto dto) {
        qBoardRepository.findById(dto.postId);
        return new CResponseQuestionUpdateDto();
    }

    public CResponseQuestionSearchDto search(CRequestQuestionSearchDto dto) {
        return new CResponseQuestionSearchDto();
    }

    public CResponseQuestionListDto viewQuestionList() {
        List<Question> all = qBoardRepository.findAll();
        return new CResponseQuestionListDto();
    }

    public CResponseMemberQuestionsDto readMemberPosts(CRequestMemberQuestionsDto dto) {
        // 후추
        return new CResponseMemberQuestionsDto();
    }
}
