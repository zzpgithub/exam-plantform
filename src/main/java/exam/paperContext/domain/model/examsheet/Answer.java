package exam.paperContext.domain.model.examsheet;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {

  private String desc;
  private LocalDateTime submitTime;
  private int score;

  public Answer(String desc, LocalDateTime submitTime) {
    this.desc = desc;
    this.submitTime = submitTime;
  }

  public Answer(String desc, LocalDateTime submitTime, int score) {
    this.desc = desc;
    this.submitTime = submitTime;
    this.score = score;
  }
}
