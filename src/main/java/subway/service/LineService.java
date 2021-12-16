package subway.service;

import static subway.Message.*;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.OutputView;

public class LineService {

    public static void clearAllLine() {
        LineRepository.clear();
    }

    public void registerLine(String lineName, String firstStationName, String lastStationName) {
        if (LineRepository.haveThisLine(lineName)) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
        if (firstStationName.equals(lastStationName)) {
            throw new IllegalArgumentException(DUPLICATE_OBJECT_ERROR);
        }
        if (!(StationRepository.haveStation(firstStationName) & StationRepository.haveStation(lastStationName))) {
            throw new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR);
        }
        LineRepository.addLine(new Line(lineName, firstStationName, lastStationName));
    }

    public void removeLine(String name) {
        if (!(LineRepository.haveThisLine(name))) {
            throw new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR);
        }
        LineRepository.deleteLineByName(name);
    }

    public void checkHaveSameName(String name) {
        if (LineRepository.haveThisLine(name)) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
    }

    public void showAllLine() {
        OutputView.showAllLine(LineRepository.lines());
    }
}
