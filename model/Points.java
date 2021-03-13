package model;

public class Points {


    private int i = 0;
    private int j = 0;
    private Points point;

    public Points getPoint() {
        return point;
    }

    public Points(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }
    public int getJ() {
        return j;
    }
    public void setI(int i) {
        this.i = i;
    }
    public void setJ(int j) {
        this.j = j;
    }
}

