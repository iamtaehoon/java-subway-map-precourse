package subway.domain;

import static subway.Constant.*;
import static subway.Message.*;

import java.util.LinkedList;
import java.util.Objects;

import subway.repository.StationRepository;

public class Line {
    private String name;
    private LinkedList<Station> stations = new LinkedList<>();


    public Line(String name, String firstStationName, String lastStationName) {
        if (name.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(LACK_OF_NAME_LENGTH_ERROR);
        }
        stations.add(new Station(firstStationName));
        stations.add(new Station(lastStationName));
        this.name = name;
    }

    // 처음, 마지막 정류장 넣어주는 메서드 구현. 각각

    public String getName() {
        return name;
    }
}
