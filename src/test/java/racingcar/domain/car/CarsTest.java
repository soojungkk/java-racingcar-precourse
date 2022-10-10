package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.playStrategy.RandomPlay;
import racingcar.dto.RacingGameInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private final String[] carNames = new String[]{"pobi", "woni"};
    private RacingGameInfo racingGameInfo;

    @BeforeEach
    void setUp() {
        racingGameInfo = new RacingGameInfo(new String[]{"pobi", "woni"}, 2);
    }

    @Test
    void Cars_셋팅() {
        Cars cars = new Cars(racingGameInfo);

        List<Car> carList = cars.getCarList();
        assertThat(carList.size()).isEqualTo(carNames.length);

        for (int i = 0; i < carNames.length; i++) {
            assertThat(carList.get(i)).isEqualTo(new Car(carNames[i]));
        }
    }

    @Test
    void 자동차들_이동() {
        Cars cars = new Cars(racingGameInfo);
        cars.go(new RandomPlay() {
            @Override
            public boolean isGo() {
                return true;
            }
        });

        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 자동차들_이동_안함() {
        Cars cars = new Cars(racingGameInfo);
        cars.go(new RandomPlay() {
            @Override
            public boolean isGo() {
                return false;
            }
        });

        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

}
