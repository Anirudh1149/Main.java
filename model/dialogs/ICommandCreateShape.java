package model.dialogs;

import model.ShapeConfiguration;
import model.ShapeFactory;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;
import view.interfaces.IShapeInterface;


public class ICommandCreateShape implements ICommand, IUndoable {

        ShapeFactory shapeFactory = new ShapeFactory();
        private final IApplicationState applicationState;
        private ShapeConfiguration shapeConfiguration;
        private IShapeList shapeList;
        private IShapeInterface shape;

        public ICommandCreateShape(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
            this.applicationState = applicationState;
            this.shapeList = shapeList;
            this.shapeConfiguration = shapeConfiguration;
        }

        @Override
        public void execute() {
            shapeConfiguration = applicationState.get_CurrentShapeConfig();
            shape = shapeFactory.createShape(shapeConfiguration);
            this.shapeList.add_Shape(shape);
            CommandHistory.add(this);
        }

        public IShapeInterface getShape() {
            return shape;
        }

        @Override
        public void undo() {
            shapeList.remove_Shape(shape);
        }

        @Override
        public void redo() {
            shapeList.add_Shape(shape);
        }


    }
