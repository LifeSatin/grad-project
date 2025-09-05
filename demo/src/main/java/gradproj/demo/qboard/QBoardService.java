package gradproj.demo.qboard;

import gradproj.demo.qboard.dto.CRequestQuestionCreationDto;
import gradproj.demo.qboard.dto.CRequestQuestionUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QBoardService {

    private final QBoardRepository qBoardRepository;

    public QBoardService(QBoardRepository qBoardRepository) {
        this.qBoardRepository = qBoardRepository;
    }

    public void createQuestion(CRequestQuestionCreationDto dto) {
        qBoardRepository.save(new Question());
    }

    public void readQuestion(long postId) {
        qBoardRepository.findById(postId);
    }

    public void updateQuestion(CRequestQuestionUpdateDto dto) {
        qBoardRepository.findById(dto.postId);
    }

    public void search(String keyword) {

    }

    public void viewQuestionList() {
        List<Question> all = qBoardRepository.findAll();
    }

    public void readMemberPosts(long memberId) {
        // 후추
    }
}
