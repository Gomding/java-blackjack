package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String NEW_LINE = System.lineSeparator();
    private final static Scanner SCANNER = new Scanner(System.in);


    public static List<String> getPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return splitNames(SCANNER.nextLine());
    }

    private static List<String> splitNames(final String inputString) {
        return Arrays.asList(inputString.split(","));
    }

    public static String getHitOrStay(String name) {
        System.out.printf("%s(은)는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", name);
        System.out.print(NEW_LINE);
        return SCANNER.nextLine().toLowerCase();
    }
}
