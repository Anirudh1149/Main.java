package model.dialogs;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

public class ICommandSelectShape implements ICommand {

    private IShapeList shapeList;
    private IShapeInterface selectedShape;
    private IApplicationState applicationState;
    Boolean containsSelectedShape = false;

    public ICommandSelectShape(IApplicationState applicationState, IShapeList shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        System.out.println("Select mode...");

        for (IShapeInterface shape : shapeList.get_ShapeList()) {
            boolean contain = shape.contains(applicationState.getStartPoint());
            if (contain) {
                containsSelectedShape = true;
                selectedShape = shape;
                shapeList.add_SelectedList(selectedShape);
                System.out.println(">> Shape selected. " + shapeList.get_SelectedShapesList().size());
                break;
            } else {
                containsSelectedShape = false;
            }
        }
        if (containsSelectedShape == false) {
            shapeList.selectedShapeListClear();
            shapeList.get_ClipBoardShapes().clear();
            System.out.println("Shape List cleared. Shapes selected: " + shapeList.get_SelectedShapesList().size());
        }
    }

    public IShapeInterface getSelectedShape() {
        return selectedShape;
    }
}

