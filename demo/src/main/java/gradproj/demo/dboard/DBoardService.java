package gradproj.demo.dboard;

import gradproj.demo.dboard.dto.CRequestDiscussBoardCreationDto;
import gradproj.demo.dboard.dto.CResponseDiscussBoardCreationDto;
import gradproj.demo.dboard.dto.CResponseDiscussBoardListViewDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBoardService {

    private final DBoardRepository dBoardRepository;

    public DBoardService(DBoardRepository dBoardRepository) {
        this.dBoardRepository = dBoardRepository;
    }

    public CResponseDiscussBoardCreationDto createBoard(CRequestDiscussBoardCreationDto dto) {
        dBoardRepository.save(new DBoard());
        return new CResponseDiscussBoardCreationDto();
    }

    public CResponseDiscussBoardListViewDto viewBoardList() {
        List<DBoard> all = dBoardRepository.findAll();
        return new CResponseDiscussBoardListViewDto();
    }
}
