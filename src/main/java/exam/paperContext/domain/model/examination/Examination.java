package exam.paperContext.domain.model.examination;

import exam.paperContext.domain.shared.Entity;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Examination implements Entity<Examination> {

  private ExaminationId examinationId;
  private LocalDateTime createTime;
  private LocalDateTime handInTime;
  private String paperId;

  public Examination(ExaminationId examinationId, LocalDateTime createTime,
      LocalDateTime handInTime, String paperId) {
    this.examinationId = examinationId;
    this.createTime = createTime;
    this.handInTime = handInTime;
    this.paperId = paperId;
  }

  public static Examination create(ExaminationId examinationId, LocalDateTime createTime,
      LocalDateTime handInTime, String paperId) {
    return new Examination(examinationId, createTime, handInTime, paperId);
  }

  @Override
  public boolean sameIdentityAs(Examination other) {
    return examinationId.sameValueAs(other.examinationId);
  }
}
