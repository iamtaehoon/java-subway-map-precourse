package subway.domain;

import static subway.Constant.*;
import static subway.Message.*;

import java.util.LinkedList;
import java.util.Objects;

import subway.repository.StationRepository;

public class Line {
    private String name;
    private Section section = new Section();

    public Line(String name, String firstStationName, String lastStationName) {
        if (name.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(LACK_OF_NAME_LENGTH_ERROR);
        }
        section.add(0, firstStationName);
        section.add(1, lastStationName);
        this.name = name;
    }

    // 처음, 마지막 정류장 넣어주는 메서드 구현. 각각

    public String getName() {
        return name;
    }

    public boolean hasThisStation(String stationName) {
        return section.hasThisStation(stationName);
    }

    public void addStation(int index, String stationName) {
        section.add(index, stationName);
    }

    public void deleteStation(String name) {
        section.delete(name);
    }
}
