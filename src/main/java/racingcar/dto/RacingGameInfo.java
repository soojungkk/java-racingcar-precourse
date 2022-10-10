package racingcar.dto;

import java.util.Arrays;
import java.util.List;

public class RacingGameInfo {
    private final List<String> carNames;
    private final int tryTime;

    public RacingGameInfo(String[] carNames, int tryTime) {
        this.carNames = Arrays.asList(carNames);
        this.tryTime = tryTime;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryTime() {
        return tryTime;
    }

}