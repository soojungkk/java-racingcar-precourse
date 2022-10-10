package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingGameInfo;

public class InputView {
    private static final String SPLIT_REGEX = ",";

    public static RacingGameInfo getRacingGameInfo () {
        String[] carNames = readCarNames();
        int tryTime = readTryTime();
        return new RacingGameInfo(carNames, tryTime);
    }

    private static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + SPLIT_REGEX + ") 기준으로 구분)");
        return Console.readLine().split(SPLIT_REGEX);
    }

    private static int readTryTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

}
