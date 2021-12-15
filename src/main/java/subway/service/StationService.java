package subway.service;

import static subway.Message.*;

import java.util.Arrays;
import java.util.List;

import subway.code.StationCode;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationService {

    public void run(StationCode stationCode) {
        try {
            if (stationCode == StationCode.REGISTER) {
                registerStation(InputView.enterRegisterStation());
            }
            if (stationCode == StationCode.REMOVE) {
                removeStation(InputView.enterRemoveStation());
            }
            if (stationCode == StationCode.LOOK_UP) {
                showAllStation();
            }
            // if (stationCode == StationCode.GO_BACK) {
            //
            // }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run(stationCode);
        }
    }

    public void registerStation(String name) {
        StationRepository.addStation(name);
    }

    public void clearAllStation() {
        StationRepository.clear();
    }

    public void removeStation(String name) {
        // 모든 노선들을 찾는다. -> 각 노선에서 이 이름을 가진 station이 있는지 찾는다
        if (LineRepository.haveThisStation(name)) {
            throw new IllegalArgumentException(STATION_ON_LINE_CANT_DELETE_ERROR);
        }
        // 있으면 오류를 반환
        StationRepository.deleteStation(name);
    }

    public void showAllStation() {
        OutputView.showAllStation(StationRepository.stations());
    }


}
