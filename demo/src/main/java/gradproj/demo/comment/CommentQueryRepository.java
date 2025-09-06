package gradproj.demo.comment;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gradproj.demo.comment.dto.CommentDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gradproj.demo.comment.QComment.*;

@Repository
public class CommentQueryRepository {

    private final JPAQueryFactory queryFactory;

    public CommentQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public List<CommentDto> getComments(long postId) {
        return queryFactory
                .select(Projections.fields(CommentDto.class,
                        comment.authorId,
                        comment.content))
                .from(comment)
                .where(comment.postId.eq(postId))
                .fetch();
    }

    public List<CommentDto> getMemberComments(long memberId) {
        return queryFactory
                .select(Projections.fields(CommentDto.class,
                        comment.authorId,
                        comment.content))
                .from(comment)
                .where(comment.authorId.eq(memberId))
                .fetch();
    }
}
