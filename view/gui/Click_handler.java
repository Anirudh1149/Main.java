package view.gui;

import model.MouseMode;
import model.Points;
import model.ShapeColor;
import model.ShapeConfiguration;
import model.dialogs.ICommandCreateShape;
import model.dialogs.ICommandSelectShape;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Click_handler extends MouseAdapter {
    private Points startPoint, endPoint;
    private IApplicationState appState;
    private IShapeList shapeList;
    private ShapeConfiguration shapeConfig;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

    public Click_handler(IApplicationState applicationState, IShapeList shapeList, ShapeConfiguration shapeConfiguration) {
        this.appState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfig = shapeConfiguration;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (appState.getActiveStartAndEndPointMode() == MouseMode.DRAW) {

            ShapeColor primaryColor = appState.getActivePrimaryColor();
            shapecolor.add(primaryColor);
            ShapeColor secondaryColor = appState.getActiveSecondaryColor();
            shapecolor.add(secondaryColor);

            if (SwingUtilities.isLeftMouseButton(e)) {
                appState.setActivePrimaryColor(shapecolor.get(0));
                appState.setActiveSecondaryColor(shapecolor.get(1));

            } else if (SwingUtilities.isRightMouseButton(e)) {
                appState.setActivePrimaryColor(shapecolor.get(1));
                appState.setActiveSecondaryColor(shapecolor.get(0));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = new Points(e.getX(), e.getY());
        appState.setEndPoint(endPoint);
        MouseMode mouseMode = appState.getActiveStartAndEndPointMode();

        switch (mouseMode) {
            case DRAW:
                ICommandCreateShape newShape = new ICommandCreateShape(appState, shapeList, shapeConfig);
                newShape.execute();
                break;

           /* case MOVE:
                ICommandCreateShape  newMove = new ICommandCreateShape(appState, shapeList);
                newMove.execute();
                break;
                */

            case SELECT:
                ICommandSelectShape newSelect = new ICommandSelectShape(appState, shapeList);
                newSelect.execute();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Points(e.getX(), e.getY());
        appState.setStartPoint(startPoint);
    }
}