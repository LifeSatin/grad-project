package gradproj.demo.discussion;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gradproj.demo.discussion.dto.DiscussionDto;
import gradproj.demo.discussion.dto.DiscussionListDto;
import gradproj.demo.discussion.dto.DiscussionSearchDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gradproj.demo.discussion.QDiscussion.*;

@Repository
public class DiscussionQueryRepository {

    private final JPAQueryFactory queryFactory;

    public DiscussionQueryRepository(JPAQueryFactory jpaQueryFactory) {
        this.queryFactory = jpaQueryFactory;
    }

    public List<DiscussionListDto> getDiscussionList(long boardId) {
        return queryFactory
                .select(Projections.fields(DiscussionListDto.class,
                        discussion.id,
                        discussion.title,
                        discussion.authorId,
                        discussion.time))
                .from(discussion)
                .where(discussion.boardId.eq(boardId))
                .fetch();
    }

    public List<DiscussionDto> getMemberDiscussionList(long memberId) {
        return queryFactory
                .select(Projections.fields(DiscussionDto.class,
                        discussion.id,
                        discussion.title,
                        discussion.authorId))
                .from(discussion)
                .where(discussion.authorId.eq(memberId))
                .fetch();
    }

    public List<DiscussionSearchDto> searchDiscussion(String query) {
        return queryFactory
                .select(Projections.fields(DiscussionSearchDto.class,
                        discussion.id,
                        discussion.title,
                        discussion.boardId))
                .from(discussion)
                .where(discussion.title.contains(query).or(discussion.content.contains(query)))
                .fetch();
    }
}
