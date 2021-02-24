package model.dialogs;


import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class Delete implements ICommand, IUndoable {
    private IShapeList shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfiguration;
    ArrayList<IShapeInterface> selectedShapes;

    public Delete(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    public void execute() {

        selectedShapes = shapeList.get_SelectedShapesList();
        for (IShapeInterface shape : selectedShapes) {
            shapeList.remove_Shape(shape);
            shapeList.observerNotification();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for (IShapeInterface shape : selectedShapes) {
            shapeList.add_Shape(shape);
        }
    }

    @Override
    public void redo() {
        for (IShapeInterface shape : selectedShapes) {
            shapeList.remove_Shape(shape);
        }
    }
}

