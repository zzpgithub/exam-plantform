package exam.paperContext.domain.model.examination;

import exam.paperContext.domain.shared.ValueObject;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ExaminationId implements ValueObject<ExaminationId> {
    private String id;

    @Override
    public boolean sameValueAs(ExaminationId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminationId examinationId = (ExaminationId) o;
        return Objects.equals(id, examinationId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
