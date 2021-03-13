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
        private ShapeConfiguration shapeConfig;
        private IShapeList shapeList;
        private IShapeInterface shape;

        public ICommandCreateShape(IShapeList shapeList, ShapeConfiguration shapeConfig , IApplicationState applicationState ) {
            this.shapeList = shapeList;
            this.shapeConfig = shapeConfig;
            this.applicationState = applicationState;

        }

        @Override
        public void execute() {
            shapeConfig = applicationState.getCurrentShapeConfig();
            shape = shapeFactory.createShape(shapeConfig);
            this.shapeList.addShape(shape);
            CommandHistory.add(this);
        }

        public IShapeInterface getShape() {
            return shape;
        }

        @Override
        public void undo() {
            shapeList.deleteShape(shape);
        }

        @Override
        public void redo() {
            shapeList.addShape(shape);
        }


    }
