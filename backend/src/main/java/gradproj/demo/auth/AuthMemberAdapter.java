package gradproj.demo.auth;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import gradproj.demo.member.MemberRepository;
import gradproj.demo.member.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static gradproj.demo.member.QMember.*;

@Repository
@RequiredArgsConstructor
public class AuthMemberAdapter {

    private final MemberRepository memberRepository;
    private final JPAQueryFactory queryFactory;

    public boolean isAuthenticationFailed(String loginId, String password) {
        return queryFactory
                .from(member)
                .where(member.loginId.eq(loginId).and(member.password.eq(password)))
                .exists().equals(Expressions.FALSE);
    }

    public String getMemberLevel(String loginId) {
        return memberRepository.findLevelByLoginId(loginId);
    }
}
