package subway.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;

public class OutputView {
    public static void showAllStation(List<Station> stations) {
        for (Station station : stations) {
            System.out.println("[INFO] " + station);
        }
    }

    public static void showAllLine(List<Line> lines) {
        for (Line line : lines) {
            System.out.println("[INFO] " + line);
        }
    }
    
}
