package view.gui;

import model.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import view.interfaces.IShapeInterface;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class OutlineTriangle extends PaintCanvasBase implements IShapeInterface {

    private ShapeConfiguration shapeConfig;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private Graphics2D paint;
    private int width, height,AX,AY;
    private Points adjustStart, adjustEnd, startPoint;
    private int[] i = new int[3];
    private int[] j = new int[3];

    private int[] is = new int[3];
    private int[] js = new int[3];



    public OutlineTriangle(ShapeConfiguration shapeConfig, int i1, int a, int i, int j) {
        this.shapeConfig = shapeConfig;
        this.shapeShadingType = shapeConfig.getShadingType();
        this.primaryColor = SingletonPattern.getColor(shapeConfig.getPrimaryColor());
        this.secondaryColor = SingletonPattern.getColor(shapeConfig.getSecondaryColor());
        this.adjustStart = shapeConfig.getAdjustStart();
        this.adjustEnd = shapeConfig.getAdjustEnd();
        this.startPoint = shapeConfig.getStartPoint();
        this.i[0] = shapeConfig.getAdjustStart().getI();
        this.i[1] = shapeConfig.getAdjustEnd().getI();
        this.i[2] = shapeConfig.getAdjustStart().getI();

        this.j[0] = shapeConfig.getAdjustStart().getJ();
        this.j[1] = shapeConfig.getAdjustEnd().getJ();
        this.j[2] = shapeConfig.getAdjustEnd().getJ();

        this.is[0]=i1-10;
        this.is[1]=i+10;
        this.is[2]=i1-10;

        this.js[0]=a-10;
        this.js[1]=j+10;
        this.js[2]=j+10;

    }


    public void draw(Graphics g) {

        paint=(Graphics2D) g;

        paint.setColor(Color.BLACK);
        paint.setStroke(new BasicStroke(8));
        paint.drawPolygon(is, js, 3);

    }

    double area(int i1, int j1, int i2, int j2, int i3, int j3) {
        return Math.abs((i1 * (j2 - j3) + i2 * (j3 - j1) + i3 * (j1 - j2)) / 2.0);
    }


    boolean isInside(int i1, int j1, int i2, int j2, int i3, int j3, int i, int j) {

        double A = area(i1, j1, i2, j2, i3, j3);
        double A1 = area(i, j, i2, j2, i3, j3);
        double A2 = area(i1, j1, i, j, i3, j3);
        double A3 = area(i1, j1, i2, j2, i, j);


        return (A == A1 + A2 + A3);
    }


    public boolean contains(Points startPoint) {
        if (isInside(i[0], j[0], i[1], j[1], i[2], j[2], startPoint.getI(), startPoint.getJ())) {
            return true;
        } else {
            return false;
        }
    }

    public Points getStartingPoint() {
        return startPoint;
    }

    public Points getEndingPoint() {
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

    public Points getAdjustStart() {
        return adjustStart;
    }

    @Override
    public Points getAdjustEnd() {
        return adjustEnd;
    }

    @Override
    public void addI(int di) {
        this.i[0] = adjustStart.getI() + di;
        this.i[1] = adjustEnd.getI() + di;
        this.i[2] = adjustStart.getI() + di;
    }

    @Override
    public void addJ(int dj) {
        this.j[0] = adjustStart.getJ() + dj;
        this.j[1] = adjustEnd.getJ() + dj;
        this.j[2] = adjustEnd.getJ() + dj;
    }

    public ShapeConfiguration getShapeConfig()
    {
        return shapeConfig;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    @Override
    public Graphics2D getGraphics2D()
    {
        return paint;
    }

}

