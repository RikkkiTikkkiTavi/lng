import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final String path;
    private final List<Line> lines = new ArrayList<>();
    private int group = 1;

    public FileManager(String path) {
        this.path = path;
    }

    public void convert() {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String firstLine = br.readLine();
            lines.add(parseToLine(firstLine, group));

            while ((line = br.readLine()) != null) {
                Line currentLine = parseToLine(line, 0);
                addGroupNumber(currentLine);
            }
        } catch (IOException ex) {
            throw new SaveException("Не удалось загрузить файл!");
        }
        System.out.println(lines);
    }

    private void addGroupNumber(Line currentLine) {
        for (int i = lines.size()- 1; i >= 0; i--) {
            Line previousLine = lines.get(i);
            if (compareLine(currentLine, previousLine)) {
                currentLine.setGroup(previousLine.getGroup());
                lines.add(currentLine);
                break;
            }
        }
        if (currentLine.getGroup() == 0) {
            group++;
            currentLine.setGroup(group);
            lines.add(currentLine);
        }
    }

    private Line parseToLine(String line, int group) {
        List<Long> numbers = new ArrayList<>();
        String[] args = line.split(";");
        for (String arg : args) {
            String value = arg.substring(1, arg.length() - 1);
            if (value.isEmpty()) {
                numbers.add(0L);
            } else {
                numbers.add(Long.parseLong(value));
            }
        }
        return new Line(numbers, group);
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
