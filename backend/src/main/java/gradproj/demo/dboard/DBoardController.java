package gradproj.demo.dboard;

import gradproj.demo.dboard.dto.*;
import org.springframework.web.bind.annotation.*;

/**
 * 구현 상태: 구현 완료
 * 기초 테스트 진행 완료
 */
@RestController
@RequestMapping("/dboard")
public class DBoardController {

    private final DBoardService dBoardService;

    public DBoardController(DBoardService dBoardService) {
        this.dBoardService = dBoardService;
    }

    /**
     * 토론 게시판 목록 조회 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 없음
     * @return boardList
     */
    @GetMapping
    public ResponseDiscussBoardListViewDto viewDiscussBoardList() {
        CResponseDiscussBoardListViewDto cdto = dBoardService.viewBoardList();
        return new ResponseDiscussBoardListViewDto(cdto.getBoardList());
    }

    /**
     * 토론 게시판 생성 기능
     * 구현 상태: 구현 완료
     * 요구 권한: 회원
     * @param originalPostId, boardName
     * @return message
     */
    @PostMapping("/create")
    public ResponseDiscussBoardCreationDto createDiscussBoard(RequestDiscussBoardCreationDto dto) {
        dBoardService.createBoard(new CRequestDiscussBoardCreationDto(dto.getBoardName()));
        return new ResponseDiscussBoardCreationDto();
    }
}
