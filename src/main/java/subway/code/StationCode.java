package subway.code;

import java.util.Arrays;

public enum StationCode {
    REGISTER("1"), REMOVE("2"), LOOK_UP("3"), GO_BACK("B");

    private String stationCode;

    StationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationCode() {
        return stationCode;
    }

    public static StationCode find(String input) {
        return Arrays.stream(StationCode.values())
            .filter(stationCode -> stationCode.getStationCode().equals(input))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."));
    }

}
