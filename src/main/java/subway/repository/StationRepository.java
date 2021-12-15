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

    public static void addStation(String name) {
        if (haveStation(name)) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
        stations.add(new Station(name));
    }

    public static boolean deleteStation(String name) {
        if (!haveStation(name)) {
            throw new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR);
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void clear() {
        stations.clear();
    }

    public static boolean haveStation(String stationName) {
        return stations.contains(new Station(stationName));
    }
}
