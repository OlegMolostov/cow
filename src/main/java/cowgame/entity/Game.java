package cowgame.entity;

import java.util.*;

public class Game {
    private int[] number;
    private List<Try> tries;

    public Game(int[] number, List<Try> tries) {
        this.number = number;
        this.tries = tries;
    }

    public Game() {
        tries=new ArrayList<>();

        Set<Integer> generated = new LinkedHashSet<>();

        Random r = new Random();
        while (generated.size() < 4) {
            generated.add(r.nextInt(10) );
        }
        this.number=generated.stream().mapToInt(Integer::intValue).toArray();
    }

    public void addTry(String number){
        this.tries.add(new Try(number,this.number));
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public List<Try> getTries() {
        return tries;
    }

    public void setTries(List<Try> tries) {
        this.tries = tries;
    }
}
