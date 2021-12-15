package subway.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

class SectionServiceTest {

    @BeforeEach
    void init() {
        StationService stationService = new StationService();
        stationService.clearAllStation();
        StationRepository.addStation("잠실역");
        StationRepository.addStation("판교역");
        StationRepository.addStation("나루역");
        StationRepository.addStation("서울대공원역");
        StationRepository.addStation("광주역");

        LineService lineService = new LineService();
        lineService.clearAllLine();
        lineService.registerLine("1호선","잠실역","판교역");
    }

    //정상적으로 구간 첫번째에 추가하는 기능
    //정상적으로 구간 마지막에 추가하는 기능
    // 중간에 ~~ 세개를 한꺼번에 보자 그냥
    @Test
    void 구간_추가_정상() {
        Line line = LineRepository.getLine("1호선");
        line.hasThisStation("나루역");
        line.addStation(2, "광주역"); // 끝
        line.addStation(0, "나루역"); // 처음
        line.addStation(2, "서울대공원역"); // 중간
    }

    @Test
    void 구간_범위_위로_벗어남_오류() {
        Line line = LineRepository.getLine("1호선");
        line.hasThisStation("나루역");
        Assertions.assertThatThrownBy(() -> line.addStation(3, "나루역")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구간_범위_아래로_벗어남_오류() {
        Line line = LineRepository.getLine("1호선");
        line.hasThisStation("나루역");
        Assertions.assertThatThrownBy(() -> line.addStation(-1, "나루역")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 노선에_역_존재_안함_오류() {
        Line line = LineRepository.getLine("1호선");
        Assertions.assertThat(line.hasThisStation("x태훈역")).isFalse();
    }

    @Test
    void 구간_이미_존재하는_역_추가_오류() {
        Line line = LineRepository.getLine("1호선");
        Assertions.assertThatThrownBy(() -> line.addStation(1, "잠실역")).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 삭제
     */
    @Test
    @DisplayName("노선에 포함된 역이 두 개 이하인데 삭제하려 하면 예외를 반환한다.")
    void 삭제할때_역_개수_부족_오류() {
        Line line = LineRepository.getLine("1호선");
        Assertions.assertThatThrownBy(() -> line.deleteStation("잠실역")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("노선에서 역을 정상적으로 삭제한다.")
    void 노선에서_역_삭제_정상() {
        Line line = LineRepository.getLine("1호선");
        line.addStation(0,"나루역");
        line.deleteStation("잠실역");
    }

}