package controller;

import model.ShapeConfiguration;
import model.dialogs.*;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController{
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    public ShapeConfiguration shapeConfiguration;
    public IShapeList shapeList;


    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeConfiguration shapeConfiguration , IShapeList shapeList ){
        this.uiModule=uiModule;
        this.applicationState=applicationState;
        this.shapeConfiguration=shapeConfiguration;
        this.shapeList=shapeList;

     }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new UndoICommand().execute());
        uiModule.addEvent(EventName.REDO, () -> new RedoICommand().execute());
        uiModule.addEvent(EventName.COPY, () ->new ShapeCopy(applicationState, shapeList, shapeConfiguration).execute());
        uiModule.addEvent(EventName.PASTE, () ->new ShapePaste(applicationState, shapeList, shapeConfiguration).execute());
        uiModule.addEvent(EventName.DELETE, () ->new ShapeDelete(applicationState, shapeList, shapeConfiguration).execute());
        uiModule.addEvent(EventName.GROUP, () ->new GroupingShape(shapeList, applicationState).execute());
        uiModule.addEvent(EventName.UNGROUP, () ->new UnGroupingClass(shapeList,applicationState).execute());

    }
}