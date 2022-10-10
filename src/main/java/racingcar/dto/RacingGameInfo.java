package racingcar.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingGameInfo {
    private final List<String> carNames;
    private final int tryTime;

    public RacingGameInfo(String[] carNames, int tryTime) {
        validateCarNames(carNames);
        validateTryTime(tryTime);

        this.carNames = Arrays.asList(carNames);
        this.tryTime = tryTime;
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차가 하나도 없습니다.");
        }
        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름이 비어져있습니다.");
            }
        }
    }

    private void validateTryTime(int tryTime) {
        if (tryTime <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 1이상이어야 합니다.");
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
