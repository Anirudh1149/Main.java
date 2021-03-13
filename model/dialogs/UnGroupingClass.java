package model.dialogs;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class UnGroupingClass implements IUndoable,ICommand {

    private ArrayList<IShapeInterface> UnGroup;
    private IShapeList shapeList;
    private IApplicationState applicationState;
    IShapeInterface gp;

    public UnGroupingClass(IShapeList shapeList, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }
    @Override
    public void execute() {
        UnGroup = new ArrayList<>();
        for (IShapeInterface shape2 : shapeList.getShapeList()) {
            if (shape2 instanceof Grouping)
                gp = shape2;
        }
        shapeList.deleteShape(gp);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        shapeList.addShape(gp);
    }
    @Override
    public void redo() {
        shapeList.deleteShape(gp);

    }
}

