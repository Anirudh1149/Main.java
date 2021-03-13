package model.interfaces;

import model.Points;
import model.*;
import view.interfaces.MouseAdapterObserverInterface;
import model.ShapeConfiguration;


public interface IApplicationState {
    void setActiveShape();
    void setActivePrimaryColor();
    void setActiveSecondaryColor();
    void setActiveShadingType();
    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();
    ShapeColor getActivePrimaryColor();
    ShapeColor getActiveSecondaryColor();
    ShapeShadingType getActiveShapeShadingType();
    MouseMode getActiveMouseMode();
    MouseMode getActiveStartAndEndPointMode();
    void setStartPoint(Points startPoint);
    void setEndPoint(Points endPoint);
    Points getStartPoint();
    Points getEndPoint();
    Points getAdjustStart();
    Points getAdjustEnd();
    ShapeConfiguration getCurrentShapeConfig();
    void setActivePrimaryColor(ShapeColor activePrimaryColor);
    void setActiveSecondaryColor(ShapeColor activeSecondaryColor);
    void observeRegister(MouseAdapterObserverInterface o);
    void observeNotification();
}
