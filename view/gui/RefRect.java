package view.gui;

import model.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.IShapeInterface;

import java.awt.*;

public class RefRect implements IShapeInterface {

    private ShapeConfiguration shapeConfig;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private int width, height;
    private Graphics2D painting;
    private Points adjustStart, adjustEnd, startPoint, endPoint;
    private ShapeType shapeType;


    public RefRect(ShapeConfiguration shapeConfig) {
        this.primaryColor = SingletonPattern.getColor(shapeConfig.getPrimaryColor());
        this.secondaryColor = SingletonPattern.getColor(shapeConfig.getSecondaryColor());
        this.shapeConfig = shapeConfig;
        this.shapeShadingType=shapeConfig.getShadingType();
        this.width = shapeConfig.getWidth();
        this.height = shapeConfig.getHeight();
        this.adjustStart = shapeConfig.getAdjustStart();
        this.adjustEnd = shapeConfig.getAdjustEnd();
        this.startPoint = shapeConfig.getStartPoint();
        this.shapeType = shapeConfig.getShapeType();
        this.endPoint = shapeConfig.getEndPoint();
    }

    @Override
    public void draw(Graphics g) {

        Color color=new Color(0,0,0,0.0f);
        g.setColor(color);
        g.drawRect(adjustStart.getI(), adjustStart.getJ(), width, height);

    }


    @Override
    public boolean contains(Points startPoint) {
        return (adjustStart.getI() < startPoint.getI() && adjustStart.getJ() < startPoint.getJ()
                && adjustStart.getI() + width > startPoint.getI() && adjustStart.getJ() + height > startPoint.getJ());
    }

    @Override
    public int getWidth()
    {
        return width;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public Points getStartingPoint()
    {
        return startPoint;
    }

    @Override
    public Points getEndingPoint()
    {
        return adjustEnd;
    }

    @Override
    public void setAdjustStart(Points adjustStart) {
        this.adjustStart = adjustStart;
    }

    @Override
    public void setAdjustEnd(Points adjustEnd) {
        this.adjustEnd = adjustEnd;
    }

    @Override
    public Points getAdjustStart() {
        return adjustStart;
    }

    @Override
    public Points getAdjustEnd() {
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


    @Override
    public ShapeConfiguration getShapeConfig() {
        return shapeConfig;
    }
}
