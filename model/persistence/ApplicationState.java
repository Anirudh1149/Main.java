package model.persistence;

import model.Points;
import model.*;
import model.dialogs.DialogProvider;
import model.dialogs.Proxy;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;
import view.interfaces.MouseAdapterObserverInterface;

import java.util.ArrayList;


public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ArrayList<MouseAdapterObserverInterface> mouseObservers = new ArrayList<>();
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private MouseMode activeMouseMode;
    private Points startPoint, endPoint, adjustStart, adjustEnd;
    private int width, height;
    Proxy undoProxy = null;
    Proxy redoProxy = null;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    private void setDefaults() {
        activeShapeType = ShapeType.RECTANGLE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeMouseMode = MouseMode.DRAW;
    }


    @Override
    public ShapeConfiguration getCurrentShapeConfig() {
        ShapeConfiguration shapeConfig = new ShapeConfiguration();
        shapeConfig.setPrimaryColor(activePrimaryColor);
        shapeConfig.setSecondaryColor(activeSecondaryColor);
        shapeConfig.setShadingType(activeShapeShadingType);
        shapeConfig.setShapeType(activeShapeType);
        shapeConfig.setEndPoint(endPoint);
        shapeConfig.setStartPoint(startPoint);
        shapeConfig.setAdjustStart(adjustStart);
        shapeConfig.setAdjustEnd(adjustEnd);
        shapeConfig.setWidth(width);
        shapeConfig.setHeight(height);
        return shapeConfig;
    }


    @Override
    public void setActivePrimaryColor(ShapeColor activePrimaryColor) {
        this.activePrimaryColor = activePrimaryColor;
    }

    @Override
    public void setActiveSecondaryColor(ShapeColor activeSecondaryColor) {
        this.activeSecondaryColor = activeSecondaryColor;
    }

    @Override
    public void setStartPoint(Points startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public void setEndPoint(Points endPoint) {
        this.endPoint = endPoint;
    }

    public void setWidth(int width) {
        Points start = getAdjustStart();
        Points end = getAdjustEnd();
        this.width = end.getI() - start.getI();
    }

    public void setHeight(int height) {
        Points start = getAdjustStart();
        Points end = getAdjustEnd();
        this.height = end.getJ() - start.getJ();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeMouseMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
        observeNotification();
    }
    @Override
    public MouseMode getActiveStartAndEndPointMode() {
        return activeMouseMode;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return activeMouseMode;
    }

    @Override
    public Points getStartPoint() {
        return startPoint;
    }

    @Override
    public Points getEndPoint() {
        return endPoint;
    }


    @Override
    public Points getAdjustStart() {
        int startX = Math.min(startPoint.getI(), endPoint.getI());
        int startY = Math.min(startPoint.getJ(), endPoint.getJ());
        adjustStart = new Points(startX, startY);
        return adjustStart;
    }

    @Override
    public Points getAdjustEnd() {
        int endX = Math.max(startPoint.getI(), endPoint.getI());
        int endY = Math.max(startPoint.getJ(), endPoint.getJ());
        adjustEnd = new Points(endX, endY);
        return adjustEnd;
    }

    public void setAdjustStart(Points adjustStart) {
        this.adjustStart = adjustStart;
    }

    public void setAdjustEnd(Points adjustEnd) {
        this.adjustEnd = adjustEnd;
    }

    @Override
    public void observeRegister(MouseAdapterObserverInterface o) {
        mouseObservers.add(o);
    }

    @Override
    public void observeNotification() {
        for (MouseAdapterObserverInterface observer : mouseObservers) {
            observer.execute();
        }
    }
}