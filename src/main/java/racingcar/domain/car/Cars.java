package racingcar.domain.car;

import racingcar.domain.playStrategy.PlayBehavior;
import racingcar.dto.RacingGameInfo;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(RacingGameInfo racingGameInfo) {
        this.carList = new ArrayList<>();
        initCarList(racingGameInfo.getCarNames());
    }

    private void initCarList(List<String> carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public void go(PlayBehavior playBehavior) {
        for (Car car : carList) {
            car.play(playBehavior.isGo());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}
