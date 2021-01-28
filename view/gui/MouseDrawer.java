package view.gui;

import model.dialogs.ICommandCreateShape;
import model.Points;
import model.ShapeColor;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseDrawer extends MouseAdapter {
    private Points startPoint;
    private Points endPoint;
    private IApplicationState applicationState;
    private IShapeList shapeList;
    private ShapeConfiguration shapeConfiguration;
    ArrayList<ShapeColor> shapecolor = new ArrayList();


    public MouseDrawer(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Points(e.getX(), e.getY());
        applicationState.setEndPoint(endPoint);
        ICommandCreateShape newShape = new ICommandCreateShape(applicationState, shapeList, shapeConfiguration);
        newShape.execute();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        applicationState.setStartPoint(startPoint);
    }
}

