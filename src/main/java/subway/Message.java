package subway;

public abstract class Message {
    // public static String
    public static String LACK_OF_NAME_LENGTH_ERROR = "2글자 이상의 이름을 입력해주세요.";
    public static String NAME_DUPLICATE_ERROR = "이미 존재하는 이름입니다.";
    public static String NOT_EXIST_OBJECT_ERROR = "해당 객체는 존재하지 않습니다.";
    public static String DUPLICATE_OBJECT_ERROR = "객체가 중복되었습니다.";
    public static String STATION_ON_LINE_CANT_DELETE_ERROR = "해당 역은 노선에 등록되어 있어 삭제가 불가능합니다.";
    public static String SECTION_OUT_RANGE_ERROR = "입력될 수 있는 범위를 초과했습니다.";
    public static String OUT_RANGE_STATION_CNT_MESSAGE = "노선에는 최소 두 개의 역이 있어야 합니다.";
}
