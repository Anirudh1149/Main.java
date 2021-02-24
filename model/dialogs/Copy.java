package model.dialogs;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

public class Copy implements ICommand {
    IApplicationState appState;
    IShapeList shapeList;
    ShapeConfiguration shapeConfiguration;

    public Copy(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void execute() {
        for (IShapeInterface shape : shapeList.get_SelectedShapesList()) {
            shapeList.add_ShapesToClipboard(shape);
        }
        System.out.println("copied shape: "+shapeList.get_ClipBoardShapes().size());
    }
}
