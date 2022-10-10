package racingcar.domain.car;

import racingcar.domain.playStrategy.RandomPlay;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = new ArrayList<>();
    }

    public void go(RandomPlay randomPlay) {
        for (Car car : carList) {
            car.play(randomPlay.isGo());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}
