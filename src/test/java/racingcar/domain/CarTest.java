package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void Car_셋팅() {
        Car car = new Car("woni");
        assertThat(car).isEqualTo(new Car("woni", 0));
    }

    @Test
    void 자동차_이름이_5글자_넘어갈경우_에러() {
        assertThatThrownBy(() -> new Car("pobiwo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자리를 넘어갈 수 없습니다.");
    }

    @Test
    void 자동차_이동() {
        Car car = new Car("woni");
        car.play(true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이동_안함() {
        Car car = new Car("woni");
        car.play(false);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
