package racinggame.strategy;

@FunctionalInterface
public interface MoveStrategy<T> {
    T move();
}
