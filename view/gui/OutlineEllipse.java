package view.gui;

import model.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.IShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class OutlineEllipse extends PaintCanvasBase implements IShapeInterface {

    private ShapeConfiguration shapeConfig;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private Graphics2D paint;
    private int width, height,widths,heights,AX,AY;
    private Points adjustStart, adjustEnd, startPoint;
    private ShapeType shapeType;

    public OutlineEllipse(ShapeConfiguration shapeConfig, int i, int j, int w, int h) {
        this.shapeConfig = shapeConfig;
        this.shapeShadingType = shapeConfig.getShadingType();
        this.primaryColor = SingletonPattern.getColor(shapeConfig.getPrimaryColor());
        this.secondaryColor = SingletonPattern.getColor(shapeConfig.getSecondaryColor());
        this.width = shapeConfig.getWidth();
        this.height = shapeConfig.getHeight();
        this.adjustStart = shapeConfig.getAdjustStart();
        this.startPoint = shapeConfig.getStartPoint();
        this.adjustEnd = shapeConfig.getAdjustEnd();
        this.shapeType = shapeConfig.getShapeType();
        this.widths = w;
        this.heights = h;
        this.AX=i;
        this.AY=j;
    }

    @Override
    public void draw(Graphics g) {

        paint=(Graphics2D) g;
        paint.setColor(Color.BLACK);
        paint.setStroke(new BasicStroke(8));
        paint.drawOval(AX-5, AY-5, widths+10, heights+10);
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
    public Points getAdjustEnd() {
        return adjustEnd;
    }

    @Override
    public Points getStartPoint() {
        return startPoint;
    }

    @Override
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

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public Graphics2D getGraphics2D() {
        return paint;
    }


}


