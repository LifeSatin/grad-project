package gradproj.demo.wiki;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gradproj.demo.wiki.QPage.*;

@Repository
@RequiredArgsConstructor
public class WikiQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<String> searchQuery(String query) {
        return jpaQueryFactory.select(page.pageName).from(page).where(page.pageName.contains(query)).fetch();
    }
}
