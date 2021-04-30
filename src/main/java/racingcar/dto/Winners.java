package racingcar.dto;

import racingcar.domain.CarName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winners {
    private final List<CarName> names;

    public Winners() {
        this.names = new ArrayList<>();
    }

    public Winners(List<CarName> names) {
        this.names = names;
    }

    public List<CarName> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }

    @Override
    public String toString() {
        return Arrays.toString(names.toArray());
    }
}
