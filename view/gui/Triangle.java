package view.gui;

import model.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import view.interfaces.IShapeInterface;

import java.awt.*;

public class Triangle implements IShapeInterface {

    private ShapeConfiguration shapeConfig;
    private Color primaryColor, secondaryColor;
    private ShapeShadingType shapeShadingType;
    private Points adjustStart, adjustEnd, startPoint;
    private int width, height;
    private int[] i = new int[3];
    private int[] j = new int[3];


    public Triangle(ShapeConfiguration shapeConfig) {
        this.shapeConfig = shapeConfig;
        this.primaryColor = SingletonPattern.getColor(shapeConfig.getPrimaryColor());
        this.secondaryColor = SingletonPattern.getColor(shapeConfig.getSecondaryColor());
        this.shapeShadingType = shapeConfig.getShadingType();
        this.adjustStart = shapeConfig.getAdjustStart();
        this.adjustEnd = shapeConfig.getAdjustEnd();
        this.startPoint = shapeConfig.getStartPoint();
        this.i[0] = shapeConfig.getAdjustStart().getI();
        this.i[1] = shapeConfig.getAdjustEnd().getI();
        this.i[2] = shapeConfig.getAdjustStart().getI();

        this.j[0] = shapeConfig.getAdjustStart().getJ();
        this.j[1] = shapeConfig.getAdjustEnd().getJ();
        this.j[2] = shapeConfig.getAdjustEnd().getJ();
    }


    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(8));
            g.drawPolygon(i, j, 3);

        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(secondaryColor);
            g.fillPolygon(i, j, 3);

        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(8));
            g.drawPolygon(i, j, 3);
            g.setColor(secondaryColor);
            g.fillPolygon(i, j, 3);
        }
    }

    double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {

        double A = area(x1, y1, x2, y2, x3, y3);
        double A1 = area(x, y, x2, y2, x3, y3);
        double A2 = area(x1, y1, x, y, x3, y3);
        double A3 = area(x1, y1, x2, y2, x, y);

        return (A == A1 + A2 + A3);
    }


    public boolean contains(Points startPoint){
        if (isInside(i[0],j[0],i[1],j[1],i[2],j[2],startPoint.getI(),startPoint.getJ())) {
            return true;
        } else{
            return false;
        }
    }

    public Points getStartingPoint(){
        return startPoint;
    }

    public Points getEndingPoint(){
        return adjustEnd;
    }

    @Override
    public void setAdjustStart(Points adjustStart){
        this.adjustStart = adjustStart;
    }

    @Override
    public void setAdjustEnd(Points adjustEnd){
        this.adjustEnd = adjustEnd;
    }

    public Points getAdjustStart(){
        return adjustStart;
    }

    @Override
    public Points getAdjustEnd(){
        return adjustEnd;
    }


    @Override
    public void addI(int di){
        this.i[0] = adjustStart.getI()+di;
        this.i[1] = adjustEnd.getI()+di;
        this.i[2] = adjustStart.getI()+di;
    }
    @Override
    public void addJ(int dj) {
        this.j[0] = adjustStart.getJ()+dj;
        this.j[1] = adjustEnd.getJ()+dj;
        this.j[2] = adjustEnd.getJ()+dj;
    }

    public ShapeConfiguration getShapeConfig() { return shapeConfig; }
    public int getWidth() { return width; }
    public int getHeight() {return height; }
}
