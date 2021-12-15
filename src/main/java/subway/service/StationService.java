package subway.service;

import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class StationService {


    public void registerStation(String name) {
        StationRepository.addStation(new Station(name));
    }
}
