package gradproj.demo.member;

import gradproj.demo.member.dto.service.request.CRequestMemberCreationDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class MemberServiceTest {

    @InjectMocks private MemberService memberService;
    @Mock private MemberRepository memberRepository;

    @Test
    public void createMemberTest() {
        long count = memberRepository.count();
        String id = "testId";
        String password = "testPW";
        String nickname = "testNickname";
        CRequestMemberCreationDto dto = new CRequestMemberCreationDto(id, password, nickname);
        memberService.createMember(dto);
        Assertions.assertThat(memberRepository.count()).isEqualTo(count + 1);
    }

    @Test
    public void readMemberInfoTest() {

    }

    @Test
    public void updateMemberNicknameTest() {

    }

    @Test
    public void updateMemberPasswordTest() {

    }

    @Test
    public void deleteMemberTest() {

    }

    @Test
    public void readMemberBookmarksTest() {

    }

    @Test
    public void updateMemberBookmarkTest() {

    }

}
