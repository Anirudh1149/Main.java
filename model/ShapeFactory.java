package model;

import view.gui.Ellipse;
import view.gui.Rectangle;
import view.gui.Triangle;
import view.interfaces.IShapeInterface;

public class ShapeFactory {
    public IShapeInterface createShape(ShapeConfiguration shapeConfig) {
        ShapeType shapeType = shapeConfig.getShapeType();
        IShapeInterface shape = null;

        if (shapeType.equals(ShapeType.RECTANGLE)) {
            shape = new Rectangle(shapeConfig);
        } else if (shapeType.equals(ShapeType.ELLIPSE)) {
            shape = new Ellipse(shapeConfig);
        } else if (shapeType.equals(ShapeType.TRIANGLE)) {
            shape = new Triangle(shapeConfig);
        }
        return shape;
    }
}

