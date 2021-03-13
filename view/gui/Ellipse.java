package view.gui;

import model.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.IShapeInterface;

import java.awt.*;

public class Ellipse implements IShapeInterface {
    private Color primaryColor, secondaryColor;
    private ShapeConfiguration shapeConfig;
    private ShapeShadingType shapeShadingType;
    private int width, height;
    private Points adjustStart, adjustEnd, startPoint;
    private ShapeType shapeType;

    public Ellipse(ShapeConfiguration shapeConfig) {
        this.primaryColor = SingletonPattern.getColor(shapeConfig.getPrimaryColor());
        this.secondaryColor = SingletonPattern.getColor(shapeConfig.getSecondaryColor());
        this.shapeShadingType = shapeConfig.getShadingType();
        this.shapeConfig = shapeConfig;
        this.width = shapeConfig.getWidth();
        this.height = shapeConfig.getHeight();
        this.adjustStart = shapeConfig.getAdjustStart();
        this.startPoint = shapeConfig.getStartPoint();
        this.adjustEnd = shapeConfig.getAdjustEnd();
        this.shapeType = shapeConfig.getShapeType();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(8));
            g.drawOval(adjustStart.getI(), adjustStart.getJ(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(secondaryColor);
            g.fillOval(adjustStart.getI(), adjustStart.getJ(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(8));
            g.drawOval(adjustStart.getI(), adjustStart.getJ(), width, height);
            g.setColor(secondaryColor);
            g.fillOval(adjustStart.getI(), adjustStart.getJ(), width, height);
        }
    }

    @Override
    public boolean contains(Points startPoint) {
        return (adjustStart.getI() < startPoint.getI() && adjustStart.getJ() < startPoint.getJ()
                && adjustStart.getI() + width > startPoint.getI() && adjustStart.getJ() + height > startPoint.getJ());
    }

    @Override
    public void setAdjustStart(Points adjustStart) {
        this.adjustStart = adjustStart;
    }

    @Override
    public void setAdjustEnd(Points adjustEnd) {
        this.adjustEnd = adjustEnd;
    }
    public Points getAdjustStart() {
        return adjustStart;
    }

    @Override
    public Points getAdjustEnd(){
        return adjustEnd;
    }
    public Points getStartPoint() {
        return startPoint;
    }
    public Points getEndPoint() {
        return adjustEnd;
    }

    @Override
    public void addI(int di) {
        adjustStart.setI(adjustStart.getI() + di);
        adjustEnd.setI(adjustEnd.getI() + di);

    }

    @Override
    public void addJ(int dj) {
        adjustStart.setJ(adjustStart.getJ() + dj);
        adjustEnd.setJ(adjustEnd.getJ() + dj);
    }

    public ShapeConfiguration getShapeConfig() {
        return shapeConfig;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }
}
