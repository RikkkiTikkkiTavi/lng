import java.util.List;
import java.util.Objects;

public class Line {

    private List<Long> values;
    private long group;

    @Override
    public String toString() {
        return "values " + values + '\'' +
               "group " + group + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return group == line.group && values.equals(line.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, group);
    }

    public Line(List<Long> values, int group) {
        this.values = values;
        this.group = group;
    }

    public List<Long> getValues() {
        return values;
    }

    public void setValues(List<Long> values) {
        this.values = values;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }
}
