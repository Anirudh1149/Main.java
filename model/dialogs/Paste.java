package model.dialogs;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IUndoable;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class Paste implements ICommand, IUndoable {
    private IShapeList shapeList;
    private IApplicationState appState;
    private ShapeConfiguration shapeConfiguration;
    private IShapeInterface newShape;
    private final ArrayList<IShapeInterface> tempShapeList = new ArrayList<IShapeInterface>();


    public Paste(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;
    }

    public void execute() {

        for (IShapeInterface selectedShape : shapeList.get_SelectedShapesList()) {
            newShape = selectedShape;
            selectedShape.addX(80);// Change to Zero
            selectedShape.addY(80);// Change to Zero

            ICommandCreateShape shape = new ICommandCreateShape(appState, shapeList, selectedShape.getShapeConfiguration());
            tempShapeList.add(shape.shapeFactory.createShape(selectedShape.getShapeConfiguration()));
        }

        for (IShapeInterface selectedShape : tempShapeList) {
            shapeList.add_Shape(selectedShape);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.remove_Shape(newShape);
    }

    @Override
    public void redo() {
        shapeList.add_Shape(newShape);
    }
}

