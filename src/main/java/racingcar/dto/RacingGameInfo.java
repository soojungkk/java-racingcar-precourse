package racingcar.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingGameInfo {
    private final List<String> carNames;
    private final int tryTime;

    public RacingGameInfo(String[] carNames, int tryTime) {
        validateCarNames(carNames);

        this.carNames = Arrays.asList(carNames);
        this.tryTime = tryTime;
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차가 하나도 없습니다.");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryTime() {
        return tryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGameInfo that = (RacingGameInfo) o;
        return tryTime == that.tryTime && Objects.equals(carNames, that.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames, tryTime);
    }

}
