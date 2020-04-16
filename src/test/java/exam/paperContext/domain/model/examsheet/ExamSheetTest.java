package exam.paperContext.domain.model.examsheet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import org.junit.Test;

public class ExamSheetTest {

  @Test
  public void should_assign_exam_sheet() {
    ExamSheetId examSheetId = new ExamSheetId("0000001");
    String studentId = "01-01";
    LocalDateTime startTime = LocalDateTime.of(2020, 4, 15, 2, 30, 0);
    ExamSheet examSheet = ExamSheet.assign(examSheetId, studentId, startTime);

    assertThat(examSheet.getExamSheetId().getId(), is("0000001"));
    assertThat(examSheet.getStudentId(), is("01-01"));
    assertThat(examSheet.getStartTime(), is(LocalDateTime.of(2020, 4, 15, 2, 30, 0)));
  }

  @Test
  public void should_submit_answer() {
    ExamSheet examSheet = ExamSheet
        .assign(new ExamSheetId("0000001"), "01-01", LocalDateTime.of(2020, 4, 15, 2, 30, 0));
    String quizId01 = "01";

    Answer answer01 = new Answer("first right answer", LocalDateTime.of(2020, 4, 15, 2, 33, 0));
    examSheet.submitAnswer(quizId01, answer01);

    String quizId02 = "02";
    Answer answer02 = new Answer("second right answer", LocalDateTime.of(2020, 4, 15, 2, 34, 0));
    examSheet.submitAnswer(quizId02, answer02);

    assertThat(examSheet.getAnswers().size(), is(2));
    assertThat(examSheet.getAnswers().get("01").getDesc(), is("first right answer"));
    assertThat(examSheet.getAnswers().get("02").getDesc(), is("second right answer"));
  }

  @Test
  public void should_review_exam_sheet() {
    ExamSheet examSheet = ExamSheet
        .assign(new ExamSheetId("0000001"), "01-01", LocalDateTime.of(2020, 4, 15, 2, 30, 0));
    String quizId01 = "01";

    Answer answer01 = new Answer("first right answer", LocalDateTime.of(2020, 4, 15, 2, 33, 0));
    examSheet.submitAnswer(quizId01, answer01);

    String quizId02 = "02";
    Answer answer02 = new Answer("second right answer", LocalDateTime.of(2020, 4, 15, 2, 34, 0));
    examSheet.submitAnswer(quizId02, answer02);

    examSheet.review();

    assertThat(examSheet.getAnswers().get("01").getScore(), is(10));
    assertThat(examSheet.getAnswers().get("02").getScore(), is(10));
  }
}
