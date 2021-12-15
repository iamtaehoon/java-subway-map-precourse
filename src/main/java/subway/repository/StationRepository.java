package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.domain.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        if (!stations.contains(new Station(name))) {
            throw new IllegalArgumentException("해당 객체는 존재하지 않습니다.");
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void clear() {
        stations.clear();
    }
}
