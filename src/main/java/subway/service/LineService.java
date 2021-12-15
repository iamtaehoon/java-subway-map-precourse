package subway.service;

import static subway.Message.*;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class LineService {

    public void clearAllLine() {
        LineRepository.clear();
    }

    public void registerLine(String lineName, String firstStationName, String lastStationName) {
        if (!(StationRepository.haveStation(firstStationName) & StationRepository.haveStation(lastStationName))) {
            throw new IllegalArgumentException("존재하지 않는 역이 들어갔습니다");
        }
        LineRepository.addLine(new Line(lineName, firstStationName, lastStationName));
    }

    public void haveThisLine(String name) {
        if (LineRepository.haveThisLine(name)) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
    }

    public void removeLine(String name) {
        if (!(LineRepository.haveThisLine(name))) {
            throw new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR);
        }
        LineRepository.deleteLineByName(name);
    }
}
