package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameInfoTest {

    @Test
    void 자동차_이름과_시도할_회수_입력() {
        RacingGameInfo racingGameInfo = new RacingGameInfo(new String[]{"pobi", "woni", "jun"}, 2);
        assertThat(racingGameInfo).isEqualTo(new RacingGameInfo(new String[]{"pobi", "woni", "jun"}, 2));
    }

    @Test
    void 자동차_이름_리스트가_비어져있을경우_에러() {
        assertThatThrownBy(() -> new RacingGameInfo(new String[]{}, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 경주할 자동차가 하나도 없습니다.");
    }

    @Test
    void 자동차_이름_리스트_중간에_비어져있을경우_에러() {
        assertThatThrownBy(() -> new RacingGameInfo(new String[]{"pobi", "", "jun"}, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 비어져있습니다.");
    }

    @Test
    void 시도할_회수가_0일경우_에러() {
        assertThatThrownBy(() -> new RacingGameInfo(new String[]{"pobi", "woni"}, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 회수는 1이상이어야 합니다.");
    }

}
