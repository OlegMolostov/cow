package cowgame.entity;

public class Try {

    private String number;//число
    private int bull;//с регистром
    private int cow;//без регистра

    public Try(String number, int bull, int cow) {

        this.number = number;
        this.bull = bull;
        this.cow = cow;
    }

    @Override
    public String toString() {
        return bull+"Б"+cow+"К";
    }

    public Try(String number, int[] arr) {
        this.number = number;

        for (int i = 0; i < 4; i++) {
            if (number.contains(arr[i] + "")){
                this.cow++;
            }
            if (arr[i] == Integer.parseInt(String.valueOf(number.charAt(i)))) {
                this.bull++;
            }
        }
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBull() {
        return bull;
    }

    public void setBull(int bull) {
        this.bull = bull;
    }

    public int getCow() {
        return cow;
    }

    public void setCow(int cow) {
        this.cow = cow;
    }
}
