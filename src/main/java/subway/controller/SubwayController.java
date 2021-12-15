package subway.controller;

import subway.code.MainCode;
import subway.code.StationCode;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;

public class SubwayController {
    private StationService stationService;
    private LineService lineService;
    private SectionService sectionService;
    private MainCode mainCode = MainCode.STATION;

    public SubwayController(StationService stationService, LineService lineService, SectionService sectionService) {
        this.stationService = stationService;
        this.lineService = lineService;
        this.sectionService = sectionService;
    }

    public void run() { // try Catch로 계속 반복 가능하게 종료 코드 나올때까지.
        while (mainCode != MainCode.QUIT) {
            InputView.showMainFunction();
            mainCode = selectMainFunction();
            executeFunction(mainCode); // mainCode enum 안에 함수도 넣어보자.
        }
    }

    private void executeFunction(MainCode mainCode) { // 상단 메서드 하나 만들어서 반복이 가능하도록.

        if (mainCode == MainCode.STATION) {
            executeStationFunction();
        }
        // if (mainCode == MainCode.LINE) {
        //
        // }
        // if (mainCode == MainCode.SECTION) {
        //
        // }
    }

    private void executeStationFunction() {
        try {
            InputView.showStationService();
            selectStationFunction();
        } catch (IllegalArgumentException e) {
            executeStationFunction();
        }
    }

    private void selectStationFunction() {
        StationCode stationCode = StationCode.find(InputView.selectFunction());
        stationService.run(stationCode);
    }

    private MainCode selectMainFunction() {
        try {
            return MainCode.find(InputView.selectFunction());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectMainFunction();
        }
    }
}
