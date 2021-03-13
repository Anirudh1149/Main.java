package view.gui;

import model.MouseMode;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.interfaces.MouseAdapterObserverInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MObserver extends JFrame implements MouseAdapterObserverInterface {
    private IApplicationState applicationState;
    private PaintCanvas paintCanvas;
    private IShapeList shapeList;
    private ShapeConfiguration shapeConfiguration;

    public MObserver(IApplicationState applicationState, PaintCanvas paintCanvas, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
        applicationState.observeRegister(this);
    }

    public void execute() {

        MouseListener[] mouseListeners = paintCanvas.getMouseListeners();
        for (MouseListener mouseListener : mouseListeners) {
            paintCanvas.removeMouseListener(mouseListener);
        }

        MouseMode startAndEndPointMode = applicationState.getActiveMouseMode();

        if (startAndEndPointMode.equals(MouseMode.DRAW))
        {
            paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
            paintCanvas.addMouseListener(new MDrawer(shapeList,shapeConfiguration, applicationState));
        }

    }
}
