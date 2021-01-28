package model;

public class Points {


    private int x = 0;
    private int y = 0;
    private Points point;

    public Points getPoint() {
        return point;
    }

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}

