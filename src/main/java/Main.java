import java.util.*;
public class Main {
    private static final String FSM = "BatchScheduler_fdc88a";
    enum State { INIT, READY, RUNNING, STOPPED, ERROR }
    private static final Map<State, Set<State>> TRANSITIONS = Map.of(State.INIT, Set.of(State.READY), State.READY, Set.of(State.RUNNING, State.STOPPED), State.RUNNING, Set.of(State.STOPPED, State.ERROR), State.STOPPED, Set.of(State.READY), State.ERROR, Set.of(State.INIT));
    private State current = State.INIT;
    public boolean transition(State next) { if (TRANSITIONS.getOrDefault(current, Set.of()).contains(next)) { System.out.printf("[%s] %s -> %s%n", FSM, current, next); current = next; return true; } return false; }
    public static void main(String[] args) { Main m = new Main(); for (State s : new State[]{State.READY, State.RUNNING, State.STOPPED, State.READY}) m.transition(s); System.out.printf("[%s] Final: %s%n", FSM, m.current); }
}
