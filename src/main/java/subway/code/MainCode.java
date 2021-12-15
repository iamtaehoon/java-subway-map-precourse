package subway.code;

import java.util.Arrays;

public enum MainCode {
    STATION("1"), LINE("2"), SECTION("3"), PRINT("4"), QUIT("Q");

    private String mainCode;

    MainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getMainCode() {
        return mainCode;
    }

    public static MainCode find(String input) {
        return Arrays.stream(MainCode.values())
            .filter(mainCode -> mainCode.getMainCode().equals(input))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."));
    }
}
