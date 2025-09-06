package gradproj.demo.notice;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gradproj.demo.notice.dto.NoticeDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gradproj.demo.notice.QNotice.*;

@Repository
public class NoticeQueryRepository {

    private final JPAQueryFactory queryFactory;

    public NoticeQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public List<NoticeDto> getNoticeList() {
        return queryFactory
                .select(Projections.fields(NoticeDto.class,
                        notice.id, notice.title))
                .from(notice)
                .fetch();
    }
}
