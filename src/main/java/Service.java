import java.util.List;
import java.util.Map;

public class Service {
    private Map<List<Long>, Long> input;

    public Service(Map<List<Long>, Long> input) {
        this.input = input;
    }

    public void print() {
        addGroup();
        System.out.println(input);
    }

    public void addGroup() {
//        int n = 0;
//        int groupNumber = 1;
//        while (n < input.size()) {
//            Line firstLine = input.get(n);
//            if (firstLine.getGroup() == 0) {
//                firstLine.setGroup(groupNumber);
//                input.add(n, firstLine);
//                groupNumber++;
//            }
//            for (int i = n + 1; i < input.size(); i++) {
//                Line line = input.get(i);
//                if(compareLine(firstLine, line)) {
//                    line.setGroup(firstLine.getGroup());
//                    input.add(i, line);
//                }
//            }
//        }
    }

    private boolean compareLine(Line firstLine, Line secondLine) {
        List<Long> firstValues = firstLine.getValues();
        List<Long> secondValues = secondLine.getValues();
        long size = Math.min(firstLine.getValues().size(), secondLine.getValues().size());
        for (int i = 0; i < size; i++) {
            if (firstValues.get(i) != null && firstValues.get(i).equals(secondValues.get(i))
                    && firstValues.get(i) != 0) {
                return true;
            }
        }
        return false;
    }
}
