package cowgame.entity;

import java.util.*;

public class Game {

    private String number;
    private List<Try> tries;
    private boolean victory;

    public boolean isVictory() {
        return victory;
    }


    public void setVictory(boolean victory) {
        this.victory = victory;
    }


    public Game() {
        tries = new ArrayList<>();

        Set<Integer> generated = new LinkedHashSet<>();

        Random r = new Random();
        while (generated.size() < 4) {
            generated.add(r.nextInt(10));
        }
        this.number = "";

        for (int i : generated
        ) {
            this.number += i;
        }

    }

    public void addTry(String number) {
        this.tries.add(new Try(number, this.number));
        if (number.equals(this.number)){
            this.victory=true;
        }
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {

        this.number = number;
    }

    public List<Try> getTries() {
        return tries;
    }

    public void setTries(List<Try> tries) {
        this.tries = tries;
    }


}
