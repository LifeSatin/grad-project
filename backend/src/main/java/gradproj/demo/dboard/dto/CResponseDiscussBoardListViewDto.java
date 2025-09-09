package gradproj.demo.dboard.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CResponseDiscussBoardListViewDto {

    public List<DBoardDto> boardList;

    public CResponseDiscussBoardListViewDto(List<DBoardDto> boardList) {
        this.boardList = boardList;
    }
}
