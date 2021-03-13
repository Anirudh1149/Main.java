package model.dialogs;

import model.interfaces.IApplicationState;
import model.interfaces.IOutline;
import model.interfaces.IShapeList;


public class Proxy implements IOutline {

    ICommand commandInterface;
    private IApplicationState applicationState;
    private IShapeList shapeList;

    private ICommandSelectShape selectShape=null;
    private ICommandCreateShape moveShape=null;


        public Proxy(ICommand command, IApplicationState applicationState, IShapeList shapeList) {
            this.applicationState = applicationState;
            this.shapeList = shapeList;
            this.commandInterface = command;
            if (command instanceof ICommandSelectShape) {
                selectShape = (ICommandSelectShape) command;
            }
        }


        @Override
        public void outline() {
            if(selectShape.containSelectShape()){
                Outline outlineClass =new Outline(applicationState,shapeList);
                outlineClass.outline();
            }
        }
    }


