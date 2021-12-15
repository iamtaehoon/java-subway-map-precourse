package subway.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
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
        StationRepository.addStation(new Station("잠실역"));
        StationRepository.addStation(new Station("판교역"));
        StationRepository.addStation(new Station("나루역"));
        StationRepository.addStation(new Station("서울대공원역"));
        StationRepository.addStation(new Station("광주역"));
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
        Assertions.assertThatThrownBy(() -> lineService.registerLine("선", "잠실역", "판교역"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("노선 이름이 중복될 경우 예외를 반환한다.")
    void 노선_이름_중복_예외() {
        LineService lineService = new LineService();
        lineService.registerLine("1호선", "잠실역", "판교역");
        Assertions.assertThatThrownBy(() -> lineService.registerLine("1호선", "나루역", "서울대공원역"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("존재하지 않는 역을 입력할 때 예외를 만든다.")
    void 역_존재_안함_예외() {
        LineService lineService = new LineService();
        lineService.registerLine("1호선", "태훈역", "판교역");
    }
}