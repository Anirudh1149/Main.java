package model.dialogs;

import model.ShapeConfiguration;
import model.ShapeFactory;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.gui.Rectangle;
import view.gui.RefRect;
import view.interfaces.IShapeInterface;

public class ICommandSelectShape implements ICommand {

    private IShapeList shapeList;
    private IShapeInterface selectShape;
    private IApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private IShapeInterface shapes, sp;
    Boolean containSelectShape = false;

    public ICommandSelectShape(IApplicationState applicationState, IShapeList shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        System.out.println("MODE");

        shapeConfiguration = applicationState.getCurrentShapeConfig();
        shapes = new RefRect(shapeConfiguration);
        this.shapeList.addShape(shapes);

        for (IShapeInterface shape : shapeList.getShapeList()) {
            boolean contain = shape.contains(applicationState.getStartPoint());
            if ((shapes.getAdjustEnd().getI()) < (shape.getAdjustEnd().getI())) {
                shapeList.addSelectList(shape);
            } else if ((shapes.getAdjustEnd().getI()) > (shape.getAdjustEnd().getI())) {
                shapeList.addSelectList(shape);
            } else if ((shapes.getAdjustEnd().getJ()) < (shape.getAdjustEnd().getJ())) {
                shapeList.addSelectList(shape);
            } else if ((shapes.getAdjustEnd().getJ()) > (shape.getAdjustEnd().getJ())) {
                shapeList.addSelectList(shape);
            } else if ((containSelectShape == false) && (shapes.getAdjustEnd() != null)) {
                shapeList.addSelectList(shape);
            } else {

            }
            if (contain) {
                containSelectShape = true;
                selectShape = shape;

                System.out.println(" Selected shape  " + shapeList.getSelectShapesList().size());
                break;
            } else {
                containSelectShape = false;
            }
        }
        if (containSelectShape == false) {
            shapeList.selectShapeListClear();
            shapeList.getClipBoardShape().clear();
            System.out.println("Cleared Shape List and  Shapes selected: " + shapeList.getSelectShapesList().size());
        }
    }
    public boolean containSelectShape() {
        return containSelectShape;
    }

    public IShapeInterface getSelectShape() {
        return selectShape;
    }
}