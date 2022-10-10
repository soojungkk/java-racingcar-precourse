package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.playStrategy.PlayBehavior;
import racingcar.dto.RacingGameInfo;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(RacingGameInfo racingGameInfo) {
        this.cars = new Cars(racingGameInfo);
    }

    public void go(PlayBehavior playBehavior) {
        cars.go(playBehavior);
    }

    public List<Car> getCarList() {
        return cars.getCarList();
    }

}
