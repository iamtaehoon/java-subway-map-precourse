package subway;

import java.util.Scanner;

import subway.controller.SubwayController;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

public class Application {
    public static void main(String[] args) {
        StationService stationService = new StationService();
        LineService lineService = new LineService();
        SectionService sectionService = new SectionService();

        SubwayController subwayController = new SubwayController(stationService,lineService,sectionService); // 빌더패턴 적용.
        subwayController.run();
    }
}
