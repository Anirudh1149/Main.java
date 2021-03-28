package view.gui;

import model.Points;
import model.ShapeColor;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import model.dialogs.Moveshape;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MMover extends MouseAdapter {
    private Points startPoint;
    private Points endPoint;
    private IApplicationState applicationState;
    private IShapeList shapeList;
    private ShapeConfiguration shapeConfig;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

    public MMover(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfig) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Points(e.getX(), e.getY());
        applicationState.setEndPoint(endPoint);
        Moveshape newMove = new Moveshape(applicationState, shapeList);
        newMove.execute();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        applicationState.setStartPoint(startPoint);
    }
}

