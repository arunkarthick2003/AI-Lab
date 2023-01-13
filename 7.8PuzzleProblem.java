import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
public class Main {
    static  byte [] goalTiles = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
    public PriorityQueue <State> queue = new PriorityQueue<State>(100, new Comparator<State>() {
        @Override
        public int compare(State a, State b) { 
            return a.priority() - b.priority();
        }
    });
    public HashSet <State> closed = new HashSet <State>();
    class State {
         byte [] tiles;    
         int spaceIndex;     
         int g;            
         int h;            
         State prev;          
        int priority() {
            return g + h;
        }
        State(byte [] initial) {
            tiles = initial;
            spaceIndex = index(tiles, 0);
            g = 0;
            h = heuristic(tiles);
            prev = null;
        }
        State(State prev, int slideFromIndex) {
            tiles = Arrays.copyOf(prev.tiles, prev.tiles.length);
            tiles[prev.spaceIndex] = tiles[slideFromIndex];
            tiles[slideFromIndex] = 0;
            spaceIndex = slideFromIndex;
            g = prev.g + 1;
            h = heuristic(tiles);
            this.prev = prev;
        } 
        boolean isGoal() {
            return Arrays.equals(tiles, goalTiles);
        } 
        State moveS() { return spaceIndex > 2 ? new State(this, spaceIndex - 3) : null; }       
        State moveN() { return spaceIndex < 6 ? new State(this, spaceIndex + 3) : null; }       
        State moveE() { return spaceIndex % 3 > 0 ? new State(this, spaceIndex - 1) : null; }       
        State moveW() { return spaceIndex % 3 < 2 ? new State(this, spaceIndex + 1) : null; }  
        void print() {
            System.out.println("g+h = " + g + "+" + h);
            for (int i = 0; i < 9; i += 3)
                System.out.println(tiles[i] + " " + tiles[i+1] + " " + tiles[i+2]);
        }
        void printAll() {
            if (prev != null) prev.printAll();
            System.out.println();
            print();
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof State) {
                State other = (State)obj;
                return Arrays.equals(tiles, other.tiles);
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Arrays.hashCode(tiles);
        }
    }
    // Add a valid (non-null and not closed) successor to the A* queue.
    void addSuccessor(State successor) {
        if (successor != null && !closed.contains(successor)) 
            queue.add(successor);
    }
    void solve(byte [] initial) {
        queue.clear();
        closed.clear();      
        long start = System.currentTimeMillis();      
        queue.add(new State(initial));
        while (!queue.isEmpty()) {        
            State state = queue.poll();       
            if (state.isGoal()) {
                long elapsed = System.currentTimeMillis() - start;
                state.printAll();
                return;
            }      
            closed.add(state);
            addSuccessor(state.moveS());
            addSuccessor(state.moveN());
            addSuccessor(state.moveW());
            addSuccessor(state.moveE());
        }
    }
    static int index(byte [] a, int val) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == val) return i;
        return -1;
    } 
    static int manhattanDistance(int a, int b) {
        return Math.abs(a / 3 - b / 3) + Math.abs(a % 3 - b % 3);
    }
    static int heuristic(byte [] tiles) {
        int h = 0;
        for (int i = 0; i < tiles.length; i++)
            if (tiles[i] != 0)
                h = Math.max(h, manhattanDistance(i, tiles[i]));
        return h;
    }
    public static void main(String[] args) {     
        byte [] initial = { 7,2,4,5,0,6,8,3,1 };
        new Main().solve(initial);
    }
}