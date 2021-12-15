package subway.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import subway.repository.StationRepository;
import subway.service.StationService;

class StationTest {

    @BeforeEach
    void init() {
        StationService stationService = new StationService();
        stationService.clearAllStation();
    }


    @ParameterizedTest()
    @ValueSource(strings = {"양재역", "서울역", "서울대공원역", "분당역", "마포역"})
    @DisplayName("역의 이름이 정상적으로 받아진 경우")
    void 역_입력_정상(String input) {
        StationService stationService = new StationService();
        stationService.registerStation(input);
        //repository에서 이름으로 찾아오는 기능 만들어야 함.
    }

    @ParameterizedTest()
    @ValueSource(strings = {"역", "서", "분", "마"})
    @DisplayName("역의 이름이 2자리보다 작으면 예외를 반환한다.")
    void 역_입력_글자수_적음_예외(String input) {
        StationService stationService = new StationService();
        Assertions.assertThatThrownBy(() -> stationService.registerStation(input))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("역 이름이 중복될 경우 예외를 반환한다.")
    void 역_이름_중복_예외() {
        StationService stationService = new StationService();
        stationService.registerStation("양재역");
        Assertions.assertThatThrownBy(() -> stationService.registerStation("양재역"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 역 삭제
     * **/
    @Test
    @DisplayName("정상적으로 역을 삭제한다.")
    void 역_삭제_정상() {
        StationService stationService = new StationService();
        stationService.registerStation("양재역");
        stationService.removeStation("양재역");
    }

    @Test
    @DisplayName("삭제하려는 역이 노선에 등록되어 있으면 예외를 반환한다.")
    void 노선에_등록된_역_삭제_예외() {
        fail(); // TODO: 아직 할 수 없음. 노선 만든 뒤 다시 작성.
    }

    @Test
    @DisplayName("삭제하려는 역이 존재하지 않는 역일 때 예외를 반환한다.")
    void 역_존재하지_않음_예외() {
        StationService stationService = new StationService();
        stationService.removeStation("양재역");
    }

}