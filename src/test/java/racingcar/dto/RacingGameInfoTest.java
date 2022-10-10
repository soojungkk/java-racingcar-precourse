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
    

}
