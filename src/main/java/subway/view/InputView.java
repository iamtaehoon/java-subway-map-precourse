package subway.view;

import java.util.Scanner;

public class InputView {
    static final Scanner scanner = new Scanner(System.in);

    public static void showMainFunction() {
        System.out.println("## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료");
    }

    public static String selectFunction() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static void showStationService() {
        System.out.println("\n## 역 관리 화면\n"
            + "1. 역 등록\n"
            + "2. 역 삭제\n"
            + "3. 역 조회\n"
            + "B. 돌아가기");
    }

    public static String enterRegisterStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String enterRemoveStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }
}
