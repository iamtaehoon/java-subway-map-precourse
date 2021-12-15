package subway.repository;

import static subway.Message.*;

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
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        if (!stations.contains(new Station(name))) {
            throw new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR);
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void clear() {
        stations.clear();
    }
}
