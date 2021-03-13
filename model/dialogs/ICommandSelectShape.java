package model.dialogs;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

public class ICommandSelectShape implements ICommand {

    private IShapeList shapeList;
    private IShapeInterface selectShape;
    private IApplicationState applicationState;
    Boolean containSelectShape = false;

    public ICommandSelectShape(IApplicationState applicationState, IShapeList shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        System.out.println("MODE");

        for (IShapeInterface shape : shapeList.getShapeList()) {
            boolean contain = shape.contains(applicationState.getStartPoint());
            if (contain) {
                containSelectShape = true;
                selectShape = shape;
                shapeList.add_SelectList(selectShape);
                System.out.println(" Selected shape  " + shapeList.getSelectShapesList().size());
                break;
            } else {
                containSelectShape = false;
            }
        }
        if (containSelectShape == false) {
            shapeList.selectShapeListClear();
            shapeList.getClipBoardShape().clear();
            System.out.println("Cleared Shape List and  Shapes selected: " + shapeList.getSelectShapesList().size());
        }
    }

    public IShapeInterface getSelectShape() {
        return selectShape;
    }
}

