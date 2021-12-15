package subway.service;

import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

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
}
