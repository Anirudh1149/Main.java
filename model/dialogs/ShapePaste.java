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
    private ShapeConfiguration shapeConfig;
    private IShapeInterface newShape;
    private final ArrayList<IShapeInterface> tempShapeList = new ArrayList<IShapeInterface>();


    public ShapePaste(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfig) {
        this.appState = applicationState;
        this.shapeConfig = shapeConfig;
        this.shapeList = shapeList;
    }

    public void execute() {

        for (IShapeInterface selectedShape : shapeList.getSelectShapesList()) {
            newShape = selectedShape;
            selectedShape.addI(20);
            selectedShape.addJ(20);

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

