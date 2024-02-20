package h04;

public interface MoveStrategyWithCounter extends MoveStrategy {
    /**
     * @return the number of steps taken during the last invocation of the start() method
     */
    public int getMoveCount();
}
