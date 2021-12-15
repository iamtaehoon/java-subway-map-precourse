package subway.service;

import java.util.List;

import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.OutputView;

public class StationService {


    public void registerStation(String name) {
        StationRepository.addStation(new Station(name));
    }

    public void clearAllStation() {
        StationRepository.clear();
    }

    public void removeStation(String name) {
        StationRepository.deleteStation(name);
    }

    public void showAllStation() {
        OutputView.showAllStation(StationRepository.stations());
    }
}
