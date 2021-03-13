package model.dialogs;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

public class ShapeCopy implements ICommand {
    IApplicationState appState;
    IShapeList shapeList;
    ShapeConfiguration shapeConfig;

    public ShapeCopy(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfig) {
        this.appState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    @Override
    public void execute() {
        for (IShapeInterface shape : shapeList.getSelectShapesList()) {
            shapeList.addShapesToClipboard(shape);
        }
        System.out.println("shape copied is : "+shapeList.getClipBoardShape().size());
    }
}
