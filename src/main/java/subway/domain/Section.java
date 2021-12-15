package subway.domain;

import static subway.Message.*;

import java.util.LinkedList;

public class Section {
    private LinkedList<Station> section = new LinkedList<>();

    public void add(Station station) {
        if (section.contains(station)) {
            throw new IllegalArgumentException(DUPLICATE_OBJECT_ERROR);
        }
        section.add(station);
    }

    public boolean hasThisStation(String stationName) {
        return section.contains(new Station(stationName));
    }
}
