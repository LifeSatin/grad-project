package gradproj.demo.auth.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import gradproj.demo.auth.QAuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static gradproj.demo.auth.QAuthToken.*;


@Repository
@RequiredArgsConstructor
public class AuthQueryRepository {

    private final JPAQueryFactory queryFactory;

    public String checkLevel(String token) {
        return queryFactory
                .select(authToken.level)
                .from(authToken)
                .where(authToken.token.eq(token))
                .fetchOne();
    }

}
