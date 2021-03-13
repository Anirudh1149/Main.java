package model;

import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.gui.MDrawer;
import view.gui.PaintCanvas;
import view.interfaces.MouseAdapterObserverInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MouseObserver extends JFrame implements MouseAdapterObserverInterface {
    private IApplicationState applicationState;
    private PaintCanvas paintCanvas;
    private ShapeConfiguration shapeConfiguration;
    private IShapeList shapeList;


    public MouseObserver(IApplicationState applicationState, PaintCanvas paintCanvas, ShapeConfiguration shapeConfiguration, IShapeList shapeList) {
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeConfiguration = shapeConfiguration;
        this.shapeList = shapeList;

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
            paintCanvas.addMouseListener(new MDrawer(shapeList, shapeConfiguration,applicationState));
        }

    }
}
