package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + NAME_MAX_LENGTH + "자리를 넘어갈 수 없습니다.");
        }
    }

    public void play(boolean isGo) {
        if (isGo) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
