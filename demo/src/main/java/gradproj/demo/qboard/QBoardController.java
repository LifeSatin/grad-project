package gradproj.demo.qboard;

import gradproj.demo.qboard.dto.controller.request.*;
import gradproj.demo.qboard.dto.controller.response.*;
import gradproj.demo.qboard.dto.service.request.*;
import gradproj.demo.qboard.dto.service.response.CResponseMemberQuestionsDto;
import gradproj.demo.qboard.dto.service.response.CResponseQuestionListDto;
import gradproj.demo.qboard.dto.service.response.CResponseQuestionReadDto;
import org.springframework.web.bind.annotation.*;

/**
 * 검색 기능 제외 구현 완료
 * 기초 테스트 진행 완료
 */
@RestController
@RequestMapping("/question")
public class QBoardController {

    private final QBoardService qBoardService;

    public QBoardController(QBoardService qBoardService) {
        this.qBoardService = qBoardService;
    }

    /**
     * 질문 게시글 목록 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @return List<postId, title, authorId>
     */
    @GetMapping
    public ResponseQuestionListDto viewQuestionBoard() {
        CResponseQuestionListDto cdto = qBoardService.viewQuestionList();
        return new ResponseQuestionListDto(cdto.getQuestionList());
    }

    /**
     * 질문 게시글 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param postId
     * @return title, content, authorId
     */
    @GetMapping("/post")
    public ResponseQuestionReadDto readQuestion(RequestQuestionReadDto dto) {
        CResponseQuestionReadDto cdto = qBoardService.readQuestion(new CRequestQuestionReadDto(dto.getPostId()));
        return new ResponseQuestionReadDto(cdto.getTitle(), cdto.getContent(), cdto.getAuthorId());
    }

    /**
     * 질문 게시글 검색 기능
     * 구현 상태: 미구현
     * 요구 권한: 없음
     * @param dto
     * @return
     */
    @GetMapping("/search")
    public ResponseQuestionSearchDto searchQuestion(RequestQuestionSearchDto dto) {
        qBoardService.search(new CRequestQuestionSearchDto());
        return new ResponseQuestionSearchDto();
    }

    /**
     * 회원 작성 질문 게시글 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @param memberId
     * @return List<title, content, memberId>
     */
    @GetMapping("/member/posts")
    public ResponseMemberQuestionsDto viewMemberPosts(RequestMemberQuestionsDto dto) {
        CResponseMemberQuestionsDto cdto = qBoardService.readMemberPosts(new CRequestMemberQuestionsDto(dto.getMemberId()));
        return new ResponseMemberQuestionsDto(cdto.getMemberQuestionList());
    }

    /**
     * 질문 게시글 작성 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 회원
     * @param title, content, authorId
     * @return message
     */
    @PostMapping("/write")
    public ResponseQuestionCreationDto createQuestion(RequestQuestionCreationDto dto) {
        qBoardService.createQuestion(new CRequestQuestionCreationDto(dto.getTitle(), dto.getContent(), dto.getAuthorId()));
        return new ResponseQuestionCreationDto();
    }

    /**
     * 질문 게시글 수정 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 본인 혹은 관리자
     * @param postId, title, content
     * @return message
     */
    @PostMapping("/update")
    public ResponseQuestionUpdateDto updateQuestion(RequestQuestionUpdateDto dto) {
        qBoardService.updateQuestion(new CRequestQuestionUpdateDto(dto.getPostId(), dto.getTitle(), dto.getContent()));
        return new ResponseQuestionUpdateDto();
    }

    // 질문 삭제: 미지원
}
