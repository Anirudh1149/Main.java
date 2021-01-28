package view.interfaces;

import model.Points;
import model.ShapeConfiguration;

import java.awt.*;

public interface IShapeInterface {
    void draw(Graphics g);

    boolean contains(Points start_Point);

    Points getStartPoint();

    Points getEndPoint();

    void addX(int dx);

    void addY(int dy);

    void setAdjustedEnd(Points adjustedEnd);

    void setAdjustedStart(Points adjustedStart);

    Points getAdjustedStart();

    Points getAdjustedEnd();

    ShapeConfiguration getShapeConfiguration();

    int getWidth();

    int getHeight();
}
