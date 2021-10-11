package racinggame.domain;

import racinggame.supplier.DistanceSupplier;
import racinggame.supplier.NameSupplier;

/**
 * 자동차의 동작을 정의한다.
 */
public interface Car extends NameSupplier<Name>, DistanceSupplier<Distance> {
}
