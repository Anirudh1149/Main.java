package view.gui;

import model.Points;
import model.ShapeColor;
import model.dialogs.ICommandSelectShape;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseSelector extends MouseAdapter {
    private Points startPoint;
    private Points endPoint;
    private IApplicationState appState;
    private IShapeList shapeList;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

    public MouseSelector(IApplicationState applicationState, IShapeList shapeList) {
        this.appState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        endPoint = new Points(e.getX(), e.getY());
        appState.setEndPoint(endPoint);
        ICommandSelectShape newSelect = new ICommandSelectShape(appState, shapeList);
        newSelect.execute();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        appState.setStartPoint(startPoint);
    }
}
