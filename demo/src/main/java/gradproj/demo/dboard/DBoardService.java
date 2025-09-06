package gradproj.demo.dboard;

import gradproj.demo.dboard.dto.CRequestDiscussBoardCreationDto;
import gradproj.demo.dboard.dto.CResponseDiscussBoardCreationDto;
import gradproj.demo.dboard.dto.CResponseDiscussBoardListViewDto;
import gradproj.demo.dboard.dto.DBoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBoardService {

    private final DBoardRepository dBoardRepository;
    private final DBoardQueryRepository dBoardQueryRepository;

    public DBoardService(DBoardRepository dBoardRepository, DBoardQueryRepository dBoardQueryRepository) {
        this.dBoardRepository = dBoardRepository;
        this.dBoardQueryRepository = dBoardQueryRepository;
    }

    public CResponseDiscussBoardCreationDto createBoard(CRequestDiscussBoardCreationDto dto) {
        dBoardRepository.save(new DBoard(dto.getName()));
        return new CResponseDiscussBoardCreationDto();
    }

    public CResponseDiscussBoardListViewDto viewBoardList() {
        List<DBoardDto> boardList = dBoardQueryRepository.getBoardList();
        return new CResponseDiscussBoardListViewDto(boardList);
    }
}
