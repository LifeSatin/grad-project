package gradproj.demo.dboard;

import gradproj.demo.dboard.dto.*;
import org.springframework.web.bind.annotation.*;

/**
 * 구현 완료
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
     * 구현 완료
     * @param originalPostId, boardName
     * @return message
     */
    @PostMapping
    public ResponseDiscussBoardCreationDto createDiscussBoard(RequestDiscussBoardCreationDto dto) {
        dBoardService.createBoard(new CRequestDiscussBoardCreationDto(dto.getBoardName()));
        return new ResponseDiscussBoardCreationDto();
    }

    /**
     * 구현 완료
     * @return boardList
     */
    @GetMapping
    public ResponseDiscussBoardListViewDto viewDiscussBoardList() {
        CResponseDiscussBoardListViewDto cdto = dBoardService.viewBoardList();
        return new ResponseDiscussBoardListViewDto(cdto.getBoardList());
    }
}
