package racingcar.dto;

import racingcar.domain.CarName;

import java.util.ArrayList;
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

    public void append(CarName name) {
        if (!names.contains(name)) {
            names.add(name);
        }
    }
}
