package model.dialogs;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class ShapePaste implements ICommand, IUndoable {
    private IShapeList shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfiguration;
    private IShapeInterface newShape;
    private final ArrayList<IShapeInterface> tempShapeList = new ArrayList<IShapeInterface>();


    public ShapePaste(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    public void execute() {

        for (IShapeInterface selectedShape : shapeList.getSelectShapesList()) {
            newShape = selectedShape;
            selectedShape.addI(0);
            selectedShape.addJ(0);

            ICommandCreateShape shape = new ICommandCreateShape( shapeList, selectedShape.getShapeConfig(),appState);
            tempShapeList.add(shape.shapeFactory.createShape(selectedShape.getShapeConfig()));
        }

        for (IShapeInterface selectedShape : tempShapeList) {
            shapeList.addShape(selectedShape);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.deleteShape(newShape);
    }

    @Override
    public void redo() {
        shapeList.addShape(newShape);
    }
}

