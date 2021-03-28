package model.dialogs;

import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.gui.OutlineEllipse;
import view.gui.OutlineRectangle;
import view.gui.OutlineTriangle;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;


public class GroupingShape implements ICommand{
    private IShapeList shapeList,shape;
    private IShapeInterface selectShape;
    private IShapeInterface len,bre;
    private IApplicationState applicationState;
    private ShapeConfiguration shapeConfig;
    private IShapeInterface shapes, s;
    int i=0,j,x=0,y=0;

    ArrayList<IShapeInterface>l=new ArrayList<>();


    public GroupingShape(IShapeList shapeList, IApplicationState applicationState) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;

    }

    @Override
    public void execute() {

        j=shapeList.getShapeList().size();
        len = shapeList.getShapeList().get(0);
        bre=shapeList.getShapeList().get(j-1);
        shapeConfig = applicationState.getCurrentShapeConfig();
        for (IShapeInterface shape : shapeList.getShapeList()) {
            x=x+shape.getWidth();
            y=y+shape.getHeight();

            if(shape instanceof OutlineRectangle) {
                s = shape;
                l.add(s);
            }
            else if (shape instanceof OutlineEllipse) {
                s = shape;
                l.add(s);
            }
            else if (shape instanceof OutlineTriangle) {
                s = shape;
                l.add(s);
            }
        }

        for(IShapeInterface sh:l) {
            shapeList.deleteShape(sh);
        }
        Grouping commandGrouping =new Grouping(shapeConfig,len.getAdjustStart().getI(),len.getAdjustStart().getJ(),x,y);
        shapes= new Grouping(shapeConfig,len.getAdjustStart().getI(),len.getAdjustStart().getJ(),x,y);
        commandGrouping.addChild(shapes);
        this.shapeList.addShape(commandGrouping);

    }
}
