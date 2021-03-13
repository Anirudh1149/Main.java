package view.interfaces;

import model.Points;
import model.ShapeConfiguration;

import java.awt.*;

public interface IShapeInterface {
    void draw(Graphics g);

    boolean contains(Points start_Point);

    Points getStartPoint();

    Points getEndPoint();

    void addI(int di);

    void addJ(int dj);

    void setAdjustEnd(Points adjustEnd);

    void setAdjustStart(Points adjustStart);

    Points getAdjustStart();

    Points getAdjustEnd();

    ShapeConfiguration getShapeConfig();

    int getWidth();

    int getHeight();
}
