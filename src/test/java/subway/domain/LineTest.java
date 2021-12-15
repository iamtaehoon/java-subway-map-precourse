package subway.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.StationService;

class LineTest {

    @BeforeEach
    void init() {
        LineService lineService = new LineService();
        lineService.clearAllLine();
        StationService stationService = new StationService();
        stationService.clearAllStation();
        StationRepository.addStation("잠실역");
        StationRepository.addStation("판교역");
        StationRepository.addStation("나루역");
        StationRepository.addStation("서울대공원역");
        StationRepository.addStation("광주역");
    }

    @Test
    void 노선_등록_정상() {
        LineService lineService = new LineService();
        lineService.registerLine("1호선", "잠실역", "판교역");
    }

    @ParameterizedTest()
    @ValueSource(strings = {"역", "서", "분", "마"})
    @DisplayName("노선의 이름이 2자리보다 작으면 예외를 만든다.")
    void 노선_이름_글자수_적음_예외() {
        LineService lineService = new LineService();
        assertThatThrownBy(() -> lineService.registerLine("선", "잠실역", "판교역"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("노선 이름이 중복될 경우 예외를 반환한다.")
    void 노선_이름_중복_예외() {
        LineService lineService = new LineService();
        lineService.registerLine("1호선", "잠실역", "판교역");
        assertThatThrownBy(() -> lineService.haveThisLine("1호선"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("존재하지 않는 역을 입력할 때 예외를 만든다.")
    void 역_존재_안함_예외() {
        LineService lineService = new LineService();
        assertThatThrownBy(() -> lineService.registerLine("1호선", "태훈역", "판교역"))
            .isInstanceOf(IllegalArgumentException.class);

    }

    /**
     * 노선 삭제
     */

    @Test
    @DisplayName("정상적으로 노선을 삭제한다.")
    void 노선_삭제_정상() {
        LineService lineService = new LineService();
        lineService.registerLine("1호선", "잠실역", "판교역");
        lineService.removeLine("1호선");
    }

    @Test
    @DisplayName("삭제하려는 노선이 존재하지 않을 때 예외를 반환한다.")
    void 존재하지_않는_노선_삭제_예외() {
        LineService lineService = new LineService();
        lineService.registerLine("1호선", "잠실역", "판교역");
        assertThatThrownBy(() -> lineService.removeLine("10호선"))
            .isInstanceOf(IllegalArgumentException.class);


    }
}