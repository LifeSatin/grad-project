package gradproj.demo.qboard;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gradproj.demo.qboard.dto.QuestionBoardDto;
import gradproj.demo.qboard.dto.QuestionDto;
import gradproj.demo.qboard.dto.QuestionListDto;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gradproj.demo.qboard.QQuestion.*;

@Repository
public class QBoardQueryRepository {

    private final JPAQueryFactory queryFactory;

    public QBoardQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public List<QuestionBoardDto> getQuestionList() {
        return queryFactory
                .select(Projections.fields(QuestionBoardDto.class,
                        question.id,
                        question.title,
                        question.authorId,
                        question.time))
                .from(question)
                .fetch();
    }

    public List<QuestionDto> getMemberQuestionList(long memberId) {
        return queryFactory
                .select(Projections.fields(QuestionDto.class,
                        question.id,
                        question.title,
                        question.authorId))
                .from(question)
                .where(question.authorId.eq(memberId))
                .fetch();
    }

    public List<QuestionDto> searchQuestion(String query) {
        return queryFactory
                .select(Projections.fields(QuestionDto.class,
                        question.id,
                        question.title,
                        question.authorId))
                .from(question)
                .where(question.title.contains(query).or(question.content.contains(query)))
                .fetch();
    }
}
