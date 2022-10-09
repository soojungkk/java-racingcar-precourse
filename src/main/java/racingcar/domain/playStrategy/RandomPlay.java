package racingcar.domain.playStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPlay {

    private static final int GO_NUM_MIN = 4;

    public boolean isGo() {
        return Randoms.pickNumberInRange(0, 9) >= GO_NUM_MIN;
    }

}
