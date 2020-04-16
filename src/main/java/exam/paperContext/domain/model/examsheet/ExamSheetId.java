package exam.paperContext.domain.model.examsheet;

import exam.paperContext.domain.shared.ValueObject;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ExamSheetId implements ValueObject<ExamSheetId> {
    private String id;

    @Override
    public boolean sameValueAs(ExamSheetId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamSheetId examSheetId = (ExamSheetId) o;
        return Objects.equals(id, examSheetId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
