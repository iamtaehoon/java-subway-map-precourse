package subway.service;

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
    }

    public void registerStation(String name) {
        try {
            StationRepository.addStation(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerStation(InputView.enterRegisterStation());
        }
    }

    public void clearAllStation() {
        StationRepository.clear();
    }

    public void removeStation(String name) {
        try {
            StationRepository.deleteStation(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            removeStation(InputView.enterRemoveStation());
        }
    }

    public void showAllStation() {
        OutputView.showAllStation(StationRepository.stations());
    }


}
