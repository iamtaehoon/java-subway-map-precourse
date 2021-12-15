package subway.domain;

import static subway.Constant.*;
import static subway.Message.*;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(LACK_OF_NAME_LENGTH_ERROR);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Station station = (Station)o;
        return Objects.equals(getName(), station.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
