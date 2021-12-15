package subway.view;

import java.util.List;

import subway.domain.Station;

public class OutputView {
    public static void showAllStation(List<Station> stations) {
        for (Station station : stations) {
            System.out.println("[INFO] " + station);
        }
    }
}
