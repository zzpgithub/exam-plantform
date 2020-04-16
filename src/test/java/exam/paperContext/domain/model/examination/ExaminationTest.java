package exam.paperContext.domain.model.examination;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import org.junit.Test;

public class ExaminationTest {

  @Test
  public void should_crete_examination() {
    ExaminationId examinationId = new ExaminationId("examination-01");
    LocalDateTime createTime = LocalDateTime.of(2020, 4, 15, 2, 30, 0);
    LocalDateTime handInTime = LocalDateTime.of(2020, 4, 15, 4, 30, 0);
    String paperId = "paper-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1";

    Examination examination = Examination.create(examinationId, createTime, handInTime, paperId);

    assertThat(examination.getExaminationId().getId(), is("examination-01"));
    assertThat(examination.getPaperId(), is("paper-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1"));
  }
}