package model;

import view.gui.Rectangle;
import view.interfaces.IShapeInterface;

public class ShapeFactory {
    public IShapeInterface createShape(ShapeConfiguration shapeConfiguration) {
        ShapeType shapeType = shapeConfiguration.getShapeType();
        IShapeInterface shape = null;

        if(shapeType.equals(ShapeType.RECTANGLE)){
            shape = new Rectangle(shapeConfiguration);
        }
        return  shape;
    }
}
