package subway.repository;

import static subway.Message.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.domain.Line;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void clear() {
        lines.clear();
    }

    public static boolean haveThisLine(String name) {
        return lines.stream().anyMatch(line -> line.getName().equals(name));
    }

    public static boolean haveThisStation(String stationName) {
        return lines.stream().anyMatch(line -> line.hasThisStation(stationName)); //하나라도 있으면 true를 반환.
    }

    public static Line getLine(String name) {
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR));
    }
}
