package subway.domain;

import static subway.Constant.*;
import static subway.Message.*;

import java.util.LinkedList;

public class Section {
    private LinkedList<Station> section = new LinkedList<>();

    public void add(int index,Station station) {
        if (section.contains(station)) {
            throw new IllegalArgumentException(DUPLICATE_OBJECT_ERROR);
        }
        if ((index < 0) || (section.size() < (index))) {
            throw new IllegalArgumentException(SECTION_OUT_RANGE_ERROR);
        }

        section.add(index,station);
    }

    public boolean hasThisStation(String stationName) {
        return section.contains(new Station(stationName));
    }

    public void delete(String name) {
        if (!hasThisStation(name)) {
            throw new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR);
        }
        if (section.size() <= MIN_STATION_CNT_IN_SECTION) {
            throw new IllegalArgumentException(OUT_RANGE_STATION_CNT_MESSAGE);
        }
    }
}
