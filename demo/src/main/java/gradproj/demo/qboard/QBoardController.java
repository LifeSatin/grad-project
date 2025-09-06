package gradproj.demo.qboard;

import gradproj.demo.qboard.dto.controller.request.*;
import gradproj.demo.qboard.dto.controller.response.*;
import gradproj.demo.qboard.dto.service.request.*;
import org.springframework.web.bind.annotation.*;

// 질문 게시판 Controller
@RestController
@RequestMapping("/question")
public class QBoardController {

    private final QBoardService qBoardService;

    public QBoardController(QBoardService qBoardService) {
        this.qBoardService = qBoardService;
    }

    // 질문 목록 조회
    @GetMapping
    public ResponseQuestionListDto viewQuestionBoard() {
        qBoardService.viewQuestionList();
        return new ResponseQuestionListDto();
    }

    // 질문 작성
    @PostMapping
    public ResponseQuestionCreationDto createQuestion(RequestQuestionCreationDto dto) {
        qBoardService.createQuestion(new CRequestQuestionCreationDto());
        return new ResponseQuestionCreationDto();
    }

    // 질문 조회
    @GetMapping("/post")
    public ResponseQuestionReadDto readQuestion(RequestQuestionReadDto dto) {
        qBoardService.readQuestion(new CRequestQuestionReadDto());
        return new ResponseQuestionReadDto();
    }

    // 질문 수정
    @PatchMapping("/post")
    public ResponseQuestionUpdateDto updateQuestion(RequestQuestionUpdateDto dto) {
        qBoardService.updateQuestion(new CRequestQuestionUpdateDto());
        return new ResponseQuestionUpdateDto();
    }

    // 질문 삭제: 미지원

    // 질문 검색
    @GetMapping("/search")
    public ResponseQuestionSearchDto searchQuestion(RequestQuestionSearchDto dto) {
        qBoardService.search(new CRequestQuestionSearchDto());
        return new ResponseQuestionSearchDto();
    }

    // 작성 게시글 목록
    @GetMapping("/member/posts")
    public ResponseMemberQuestionsDto viewMemberPosts(RequestMemberQuestionsDto dto) {
        qBoardService.readMemberPosts(new CRequestMemberQuestionsDto());
        return new ResponseMemberQuestionsDto();
    }
}
