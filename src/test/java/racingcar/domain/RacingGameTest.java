package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.playStrategy.RandomPlay;
import racingcar.dto.RacingGameInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private final String[] carNames = new String[]{"pobi", "woni"};
    private RacingGameInfo racingGameInfo;

    @BeforeEach
    void setUp() {
        racingGameInfo = new RacingGameInfo(new String[]{"pobi", "woni"}, 2);
    }

    @Test
    void RacingGame_셋팅() {
        RacingGame racingGame = new RacingGame(racingGameInfo);

        List<Car> carList = racingGame.getCarList();
        assertThat(carList.size()).isEqualTo(carNames.length);

        for (int i = 0; i < carNames.length; i++) {
            assertThat(carList.get(i)).isEqualTo(new Car(carNames[i]));
        }
    }

    @Test
    void 자동차들_이동() {
        RacingGame racingGame = new RacingGame(racingGameInfo);
        racingGame.go(new RandomPlay() {
            @Override
            public boolean isGo() {
                return true;
            }
        });

        List<Car> carList = racingGame.getCarList();
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 자동차들_이동_안함() {
        RacingGame racingGame = new RacingGame(racingGameInfo);
        racingGame.go(new RandomPlay() {
            @Override
            public boolean isGo() {
                return false;
            }
        });

        List<Car> carList = racingGame.getCarList();
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

}
