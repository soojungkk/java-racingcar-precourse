package racingcar;

import racingcar.domain.Winners;
import racingcar.domain.playStrategy.RandomPlay;
import racingcar.dto.RacingGameInfo;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        // input racingCar names and tryCount
        RacingGameInfo racingGameInfo = InputView.getRacingGameInfo();

        RacingGame racingGame = new RacingGame(racingGameInfo);
        int tryTime = racingGameInfo.getTryTime();

        for (int i = 0; i < tryTime; i++) {
            racingGame.go(new RandomPlay());

            // print racingCar move
            OutputView.printRacingGame(i, racingGame.getCarList());
        }

        // print winners
        OutputView.printWinners(Winners.getWinners(racingGame.getCarList()));
    }
}
