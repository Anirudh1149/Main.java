package model.interfaces;

import model.Points;
import model.*;
import view.interfaces.MouseAdapterObserverInterface;


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

    void setStartPoint(Points startPoint);
    void setEndPoint(Points endPoint);
    Points getAdjustedStart();
    Points getAdjustedEnd();
    ShapeConfiguration get_CurrentShapeConfig();
    void observerRegister(MouseAdapterObserverInterface o);
    void observersNotification();
}
