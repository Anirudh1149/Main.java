package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeConfiguration;
import model.IShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import model.MouseObserver;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        IShapeList shapeList = new IShapeList();
        ShapeConfiguration shapeConfig = new ShapeConfiguration();
        PaintCanvas paintCanvas = new PaintCanvas(shapeList);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);



        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));

        IJPaintController paintController = new JPaintController(uiModule, appState, shapeConfig, shapeList);
        MouseObserver mouseObserver = new MouseObserver(appState, paintCanvas, shapeConfig, shapeList);
        mouseObserver.execute();
        paintController.setup();


    }
}
