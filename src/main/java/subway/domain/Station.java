package subway.domain;

import static subway.Constant.*;

public class Station {
    private String name;

    public Station(String name) {
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException("2글자 이상의 이름을 입력해주세요.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
