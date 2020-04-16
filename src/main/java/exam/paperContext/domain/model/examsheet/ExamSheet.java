package exam.paperContext.domain.model.examsheet;

import exam.paperContext.domain.shared.Entity;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamSheet implements Entity<ExamSheet> {

  private ExamSheetId examSheetId;
  private String studentId;
  private LocalDateTime startTime;
  private LocalDateTime handInTime;
  private Map<String, Answer> answers = new HashMap<>();


  public ExamSheet(ExamSheetId examSheetId,
      String studentId, LocalDateTime startTime) {
    this.examSheetId = examSheetId;
    this.studentId = studentId;
    this.startTime = startTime;

  }

  public static ExamSheet assign(ExamSheetId examSheetId,
      String studentId, LocalDateTime startTime) {
    return new ExamSheet(examSheetId, studentId, startTime);
  }

  public void submitAnswer(String quizId, Answer answer) {
    answers.put(quizId, answer);
  }

  public void handIn() {
  }

  public void review() {
    this.getAnswers().forEach((s, answer) -> answer.setScore(10));
    this.setHandInTime(LocalDateTime.now());
  }

  @Override
  public boolean sameIdentityAs(ExamSheet other) {
    return examSheetId.sameValueAs(other.examSheetId);
  }
}
