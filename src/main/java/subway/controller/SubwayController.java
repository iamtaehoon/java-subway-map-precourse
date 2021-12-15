package subway.controller;

import java.util.Arrays;

import subway.code.MainCode;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;

public class SubwayController {
    private StationService stationService;
    private LineService lineService;
    private SectionService sectionService;
    private MainCode mainCode;

    public SubwayController(StationService stationService, LineService lineService, SectionService sectionService) {
        this.stationService = stationService;
        this.lineService = lineService;
        this.sectionService = sectionService;
    }

    public void run() {
        InputView.showMainFunction();
        MainCode mainCode = selectMainFunction();
        
    }

    private MainCode selectMainFunction() {
        try {
            return MainCode.find(InputView.selectMainFunction());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMainFunction();
        }
    }
}
