package gradproj.demo.qboard;

import gradproj.demo.qboard.dto.controller.request.*;
import gradproj.demo.qboard.dto.controller.response.*;
import gradproj.demo.qboard.dto.service.request.*;
import gradproj.demo.qboard.dto.service.response.CResponseMemberQuestionsDto;
import gradproj.demo.qboard.dto.service.response.CResponseQuestionListDto;
import gradproj.demo.qboard.dto.service.response.CResponseQuestionReadDto;
import org.springframework.web.bind.annotation.*;

// 질문 게시판 Controller
@RestController
@RequestMapping("/question")
public class QBoardController {

    private final QBoardService qBoardService;

    public QBoardController(QBoardService qBoardService) {
        this.qBoardService = qBoardService;
    }

    /**
     * 구현 완료, 테스트 미진행
     * @return List<postId, title, authorId>
     */
    @GetMapping
    public ResponseQuestionListDto viewQuestionBoard() {
        CResponseQuestionListDto cdto = qBoardService.viewQuestionList();
        return new ResponseQuestionListDto(cdto.getQuestionList());
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param title, content, authorId
     * @return message
     */
    @PostMapping
    public ResponseQuestionCreationDto createQuestion(RequestQuestionCreationDto dto) {
        qBoardService.createQuestion(new CRequestQuestionCreationDto(dto.getTitle(), dto.getContent(), dto.getAuthorId()));
        return new ResponseQuestionCreationDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param postId
     * @return title, content, authorId
     */
    @GetMapping("/post")
    public ResponseQuestionReadDto readQuestion(RequestQuestionReadDto dto) {
        CResponseQuestionReadDto cdto = qBoardService.readQuestion(new CRequestQuestionReadDto(dto.getPostId()));
        return new ResponseQuestionReadDto(cdto.getTitle(), cdto.getContent(), cdto.getAuthorId());
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param postId
     * @return message
     */
    @PatchMapping("/post")
    public ResponseQuestionUpdateDto updateQuestion(RequestQuestionUpdateDto dto) {
        qBoardService.updateQuestion(new CRequestQuestionUpdateDto(dto.getPostId(), dto.getTitle(), dto.getContent()));
        return new ResponseQuestionUpdateDto();
    }

    // 질문 삭제: 미지원

    /**
     *
     * @param dto
     * @return
     */
    @GetMapping("/search")
    public ResponseQuestionSearchDto searchQuestion(RequestQuestionSearchDto dto) {
        qBoardService.search(new CRequestQuestionSearchDto());
        return new ResponseQuestionSearchDto();
    }

    /**
     * 구현 완료, 테스트 미진행
     * @param memberId
     * @return List<title, content, memberId>
     */
    @GetMapping("/member/posts")
    public ResponseMemberQuestionsDto viewMemberPosts(RequestMemberQuestionsDto dto) {
        CResponseMemberQuestionsDto cdto = qBoardService.readMemberPosts(new CRequestMemberQuestionsDto(dto.getMemberId()));
        return new ResponseMemberQuestionsDto(cdto.getMemberQuestionList());
    }
}
