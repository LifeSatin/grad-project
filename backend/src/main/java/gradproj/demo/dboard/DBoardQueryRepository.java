package gradproj.demo.dboard;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gradproj.demo.dboard.dto.DBoardDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gradproj.demo.dboard.QDBoard.*;

@Repository
public class DBoardQueryRepository {

    private final JPAQueryFactory queryFactory;

    public DBoardQueryRepository(JPAQueryFactory jpaQueryFactory) {
        this.queryFactory = jpaQueryFactory;
    }

    public List<DBoardDto> getBoardList() {
        return queryFactory
                .select(Projections.fields(DBoardDto.class,
                        dBoard.id,
                        dBoard.name))
                .from(dBoard)
                .fetch();
    }
}
