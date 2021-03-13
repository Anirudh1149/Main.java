package model.dialogs;


import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class ShapeDelete implements ICommand, IUndoable {
    private IShapeList shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfig;
    ArrayList<IShapeInterface> selectShapes;

    public ShapeDelete(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfig) {
        this.appState = applicationState;
        this.shapeConfig = shapeConfig;
        this.shapeList = shapeList;
    }

    public void execute() {

        selectShapes = shapeList.getSelectShapesList();
        for (IShapeInterface shape : selectShapes) {
            shapeList.deleteShape(shape);
            shapeList.observerNotification();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShapeInterface shape : selectShapes) {
            shapeList.addShape(shape);
        }
    }

    @Override
    public void redo() {
        for (IShapeInterface shape : selectShapes) {
            shapeList.deleteShape(shape);
        }
    }
}

