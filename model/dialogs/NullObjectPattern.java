package model.dialogs;

import model.Points;
import model.ShapeConfiguration;
import view.interfaces.IShapeInterface;

import java.awt.*;

public class NullObjectPattern implements IShapeInterface {
    @Override
    public void draw(Graphics g) {
        System.out.println("Cannot execute Null Shape");
    }

    @Override
    public boolean contains(Points start_Point) {
        return false;
    }

    @Override
    public Points getStartPoint() {
        return null;
    }

    @Override
    public Points getEndPoint() {
        return null;
    }

    @Override
    public void addI(int di) {
        System.out.println("0 X coordinates for Null Shape");
    }

    @Override
    public void addJ(int dj) {
        System.out.println("0 Y coordinates for Null Shape");
    }

    @Override
    public void setAdjustEnd(Points adjustEnd) {
        System.out.println("0 End coordinates for Null Shape");
    }

    @Override
    public void setAdjustStart(Points adjustStart) {
        System.out.println("0 Start coordinates for Null Shape");
    }

    @Override
    public Points getAdjustStart() {
        return null;
    }

    @Override
    public Points getAdjustEnd() {
        return null;
    }

    @Override
    public ShapeConfiguration getShapeConfig() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }


}

