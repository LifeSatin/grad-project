package gradproj.demo.qboard;

import gradproj.demo.auth.AuthToken;
import gradproj.demo.auth.repository.AuthRepository;
import gradproj.demo.member.Member;
import gradproj.demo.member.MemberRepository;
import gradproj.demo.qboard.dto.QuestionBoardDto;
import gradproj.demo.qboard.dto.QuestionDto;
import gradproj.demo.qboard.dto.QuestionListDto;
import gradproj.demo.qboard.dto.service.request.*;
import gradproj.demo.qboard.dto.service.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QBoardService {

    private final QBoardRepository qBoardRepository;
    private final QBoardQueryRepository qBoardQueryRepository;
    private final AuthRepository authRepository;
    private final MemberRepository memberRepository;

    public CResponseQuestionCreationDto createQuestion(CRequestQuestionCreationDto dto) {
        String authorToken = dto.getAuthorToken();
        AuthToken token = authRepository.findById(authorToken).orElseThrow();
        long authorId = token.getId();

        Question save = qBoardRepository.save(new Question(dto.getTitle(), dto.getContent(), authorId, dto.getTime(), dto.getFileId(), dto.getFileName()));
        return new CResponseQuestionCreationDto(save.getId());
    }

    public CResponseQuestionReadDto readQuestion(CRequestQuestionReadDto dto) {
        Optional<Question> byId = qBoardRepository.findById(dto.getPostId());
        Question question = byId.orElseThrow();
        Member member = memberRepository.findById(question.getAuthorId()).orElseThrow();
        return new CResponseQuestionReadDto(question.getTitle(), question.getContent(), member.getNickname(), question.getTime(), question.getFileId(), question.getFileName());
    }

    public CResponseQuestionUpdateDto updateQuestion(CRequestQuestionUpdateDto dto) {
        Optional<Question> byId = qBoardRepository.findById(dto.getPostId());
        Question question = byId.orElseThrow();
        question.update(dto.getTitle(), dto.getContent());
        qBoardRepository.save(question);
        return new CResponseQuestionUpdateDto();
    }

    public CResponseQuestionSearchDto search(CRequestQuestionSearchDto dto) {
        List<QuestionDto> result = qBoardQueryRepository.searchQuestion(dto.getKeyword());
        return new CResponseQuestionSearchDto(result);
    }

    public CResponseQuestionListDto viewQuestionList() {
        List<QuestionBoardDto> questionList = qBoardQueryRepository.getQuestionList();
        List<QuestionListDto> result = questionList.stream().map(k -> new QuestionListDto(k.getId(), k.getTitle(), k.getTime(), memberRepository.findById(k.getAuthorId()).orElseThrow().getNickname())).toList();
        return new CResponseQuestionListDto(result);
    }

    public CResponseMemberQuestionsDto readMemberPosts(CRequestMemberQuestionsDto dto) {
        List<QuestionDto> memberQuestionList = qBoardQueryRepository.getMemberQuestionList(dto.getMemberId());
        return new CResponseMemberQuestionsDto(memberQuestionList);
    }
}
