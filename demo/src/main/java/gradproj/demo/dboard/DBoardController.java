package gradproj.demo.dboard;

import gradproj.demo.dboard.dto.CRequestDiscussBoardCreationDto;
import gradproj.demo.dboard.dto.RequestDiscussBoardCreationDto;
import gradproj.demo.dboard.dto.ResponseDiscussBoardCreationDto;
import gradproj.demo.dboard.dto.ResponseDiscussBoardListViewDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dboard")
public class DBoardController {

    private final DBoardService dBoardService;

    public DBoardController(DBoardService dBoardService) {
        this.dBoardService = dBoardService;
    }

    // 토론 게시판 생성
    @PostMapping
    public ResponseDiscussBoardCreationDto createDiscussBoard(RequestDiscussBoardCreationDto dto) {
        dBoardService.createBoard(new CRequestDiscussBoardCreationDto());
        return new ResponseDiscussBoardCreationDto();
    }

    // 토론 게시판 목록 조회
    @GetMapping
    public ResponseDiscussBoardListViewDto viewDiscussBoardList() {
        dBoardService.viewBoardList();
        return new ResponseDiscussBoardListViewDto();
    }

}
