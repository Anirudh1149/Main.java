package view.gui;

import model.MouseMode;
import model.ShapeConfiguration;
import model.interfaces.IApplicationState;
import view.interfaces.IMouseAdapterObserver;
import model.interfaces.IShapeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MObserver extends JFrame implements IMouseAdapterObserver {
    private IApplicationState applicationState;
    private PaintCanvas paintCanvas;
    private IShapeList shapeList;
    private ShapeConfiguration shapeConfig;

    public MObserver(IApplicationState applicationState, PaintCanvas paintCanvas, ShapeConfiguration shapeConfig, IShapeList shapeList) {
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfig;
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
            paintCanvas.addMouseListener(new MDrawer(shapeList,shapeConfig, applicationState));
        }
        else if (startAndEndPointMode.equals(MouseMode.SELECT))
        {
            paintCanvas.setCursor((new Cursor(Cursor.HAND_CURSOR)));
            paintCanvas.addMouseListener(new MSelector(applicationState, shapeList));

        }
        else if (startAndEndPointMode.equals(MouseMode.MOVE))
        {
            paintCanvas.setCursor((new Cursor(Cursor.MOVE_CURSOR)));
            paintCanvas.addMouseListener(new MMover(applicationState, shapeList,shapeConfig));
        }


    }
}
