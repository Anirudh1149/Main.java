package model.dialogs;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class Moveshape implements ICommand, IUndoable {
    private IApplicationState appState;
    private IShapeList shapeList;
    private IShapeInterface old_shape;
    private IShapeInterface new_shape;
    private ArrayList<IShapeInterface> temporaryShapeList;


    public Moveshape(IApplicationState applicationState, IShapeList shapeList) {
        this.appState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {

        temporaryShapeList = new ArrayList<>();

        int dx = appState.getEndPoint().getI() - appState.getStartPoint().getI();
        int dy = appState.getEndPoint().getJ() - appState.getStartPoint().getJ();

        for (IShapeInterface selectedShape : shapeList.getSelectShapesList()) {
            old_shape = selectedShape;
            temporaryShapeList.add(old_shape);
            shapeList.deleteShape(old_shape);

            for (IShapeInterface tempShape : temporaryShapeList) {
                tempShape.addI(dx);
                tempShape.addJ(dy);
                new_shape = tempShape;
                shapeList.addShape(new_shape);
            }
            temporaryShapeList.clear();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.deleteShape(new_shape);
        shapeList.addShape(old_shape);
    }

    @Override
    public void redo() {
        shapeList.addShape(new_shape);
        shapeList.deleteShape(old_shape);
    }
}

