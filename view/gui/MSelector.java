package view.gui;

import model.Points;
import model.ShapeColor;
import model.dialogs.ICommand;
import model.dialogs.ICommandSelectShape;
import model.dialogs.Proxy;
import model.interfaces.IApplicationState;
import model.interfaces.IOutline;
import model.interfaces.IShapeList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MSelector extends MouseAdapter {
    private Points startPoint;
    private Points endPoint;
    private IApplicationState appState;
    private IShapeList shapeList;
    ICommand com=null;
    Proxy selectShape;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

    public MSelector(IApplicationState applicationState, IShapeList shapeList) {
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
        selectShape = new Proxy(com,appState, shapeList);
        printOutline(selectShape);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        appState.setStartPoint(startPoint);
    }
    public static void printOutline(IOutline outlineOp) {
        outlineOp.outline();
    }
}
