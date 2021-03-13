package model;

import view.interfaces.IShapeInterface;


public class ShapeConfiguration {

    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Points startPoint;
    private Points endPoint;
    private ShapeShadingType shadingType;
    private  ShapeType shapeType;
    private IShapeInterface selectShape;
    private Points adjustStart;
    private Points adjustEnd;
    private int width;
    private int height;




    public void setPrimaryColor(ShapeColor primaryColor)
    {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor)
    {
        this.secondaryColor = secondaryColor;
    }

    public void setStartPoint(Points startPoint)
    {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Points endPoint)
    {
        this.endPoint = endPoint;
    }

    public void setShadingType(ShapeShadingType shadeType)
    {
        this.shadingType = shadeType;
    }

    public void setShapeType(ShapeType shapeType)
    {
        this.shapeType = shapeType;
    }

    public ShapeColor getPrimaryColor()
    {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor()
    {
        return secondaryColor;
    }

    public Points getStartPoint()
    {
        return startPoint;
    }

    public Points getEndPoint()
    {
        return endPoint;
    }

    public ShapeShadingType getShadingType()
    {
        return shadingType;
    }

    public ShapeType getShapeType()
    {
        return shapeType;
    }


    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        Points adjustStart = getAdjustStart();
        Points adjustEnd = getAdjustEnd();
        return adjustEnd.getI() - adjustStart.getI();
    }

    public int getHeight() {
        Points adjustedStart = getAdjustStart();
        Points adjustedEnd = getAdjustEnd();
        return adjustedEnd.getJ() - adjustedStart.getJ();
    }

    public Points getAdjustStart() {
        int startI = Math.min(startPoint.getI(), endPoint.getI());
        int startJ = Math.min(startPoint.getJ(), endPoint.getJ());
        return new Points(startI, startJ);
    }

    public Points getAdjustEnd() {
        int endI = Math.max(startPoint.getI(), endPoint.getI());
        int endJ = Math.max(startPoint.getJ(), endPoint.getJ());
        return new Points(endI, endJ);
    }

    public void setAdjustEnd(Points adjustEnd)
    {
        this.adjustEnd = adjustEnd;
    }

    public void setAdjustStart(Points adjustStart)
    {
        this.adjustStart = adjustStart;
    }


    public void setSelectShape(IShapeInterface shape) {
        this.selectShape = shape;

    }

    public IShapeInterface getSelectedShape() {
        return selectShape;
    }
}

