package model.dialogs;

import model.ShapeConfiguration;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IOutline;
import model.interfaces.IShapeList;
import view.gui.OutlineEllipse;
import view.gui.OutlineRectangle;
import view.gui.OutlineTriangle;
import view.interfaces.IShapeInterface;

public class Outline implements IOutline {


    private ShapeConfiguration shapeConfig;
    private IApplicationState applicationState;
    private IShapeInterface shapess;
    private IShapeList shapeList;

    public Outline(IApplicationState applicationState, IShapeList shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void outline() {
        shapeConfig = applicationState.getCurrentShapeConfig();

        ShapeType shapeType = shapeConfig.getShapeType();
        for (IShapeInterface shape : shapeList.getSelectShapesList()) {
            if (shapeType.equals(ShapeType.RECTANGLE)) {
                shapess = new OutlineRectangle(shapeConfig,shape.getAdjustStart().getI(),shape.getAdjustStart().getJ(),shape.getWidth(), shape.getHeight());
                this.shapeList.addShape(shapess);
            } else if (shapeType.equals(ShapeType.ELLIPSE)) {
                shapess = new OutlineEllipse(shapeConfig,shape.getAdjustStart().getI(),shape.getAdjustStart().getJ(),shape.getWidth(), shape.getHeight());
                this.shapeList.addShape(shapess);
            } else if (shapeType.equals(ShapeType.TRIANGLE)) {
                shapess = new OutlineTriangle(shapeConfig,shape.getAdjustStart().getI(),shape.getAdjustStart().getJ(),shape.getAdjustEnd().getI(), shape.getAdjustEnd().getJ());
                this.shapeList.addShape(shapess);
            }
        }
    }
}
