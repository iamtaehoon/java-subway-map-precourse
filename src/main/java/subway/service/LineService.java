package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;

public class LineService {

    public void clearAllLine() {
        LineRepository.clear();
    }

    public void registerLine(String lineName, String startStationName, String endStationName) {
        Line line = new Line(lineName);

    }

    public void hasThisLine(String s) {
    }

    public void removeLine(String s) {
    }
}
