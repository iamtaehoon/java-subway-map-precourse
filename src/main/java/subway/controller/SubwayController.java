package subway.controller;

import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

public class SubwayController {
    private StationService stationService;
    private LineService lineService;
    private SectionService sectionService;

    public SubwayController(StationService stationService, LineService lineService, SectionService sectionService) {
        this.stationService = stationService;
        this.lineService = lineService;
        this.sectionService = sectionService;
    }

    public void run() {
        System.out.println("hello");
    }
}
