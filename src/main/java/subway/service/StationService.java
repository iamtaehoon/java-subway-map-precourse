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
        if (StationRepository.haveStation(name)) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR);
        }
        StationRepository.addStation(name);
    }

    public static void clearAllStation() {
        StationRepository.clear();
    }

    public void removeStation(String name) {
        if (!StationRepository.haveStation(name)) {
            throw new IllegalArgumentException(NOT_EXIST_OBJECT_ERROR);
        }
        if (LineRepository.haveThisStation(name)) {
            throw new IllegalArgumentException(STATION_ON_LINE_CANT_DELETE_ERROR);
        }
        StationRepository.deleteStation(name);
    }

    public void showAllStation() {
        OutputView.showAllStation(StationRepository.stations());
    }


}
