package model;

import view.gui.Ellipse;
import view.gui.Rectangle;
import view.gui.Triangle;
import view.interfaces.IShapeInterface;

public class ShapeFactory {
    public IShapeInterface createShape(ShapeConfiguration shapeConfiguration) {
        ShapeType shapeType = shapeConfiguration.getShapeType();
        IShapeInterface shape = null;

        if (shapeType.equals(ShapeType.RECTANGLE)) {
            shape = new Rectangle(shapeConfiguration);
        } else if (shapeType.equals(ShapeType.ELLIPSE)) {
            shape = new Ellipse(shapeConfiguration);
        } else if (shapeType.equals(ShapeType.TRIANGLE)) {
            shape = new Triangle(shapeConfiguration);
        }
        return shape;
    }
}

