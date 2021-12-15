package subway.domain;

import static subway.Constant.*;
import static subway.Message.*;

import java.util.Objects;

public class Line {
    private String name;
    private Station firstStation;
    private Station lastStation;

    public Line(String name) {
        if (name.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(LACK_OF_NAME_LENGTH_ERROR);
        }
        this.name = name;
    }

    // 처음, 마지막 정류장 넣어주는 메서드 구현. 각각

    public String getName() {
        return name;
    }
}
