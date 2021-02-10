package model;


import model.interfaces.IShape;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class ShapeList implements IShapeList {
    private final ArrayList<IShapeInterface> internalShapesList;
    private final ArrayList<IShape> observers;
    private final ArrayList<IShapeInterface> selectedShapesList;
    private final ArrayList<IShapeInterface> clipBoard;


    public ShapeList() {
        internalShapesList = new ArrayList<IShapeInterface>();
        observers = new ArrayList<IShape>();
        selectedShapesList = new ArrayList<IShapeInterface>();
        clipBoard = new ArrayList<IShapeInterface>();

    }

    public void add_Shape(IShapeInterface shapes) {
        internalShapesList.add(shapes);
        observerNotification();
    }

    public void remove_Shape(IShapeInterface shape) {
        internalShapesList.remove(shape);
        observerNotification();
    }

    public ArrayList<IShapeInterface> get_ShapeList() {
        return internalShapesList;
    }

    @Override
    public void subscribe(IShape observer) {
        observers.add(observer);
    }

    @Override
    public void unsubcribe(IShape observer) {
        observers.remove(observer);
    }

    @Override
    public void observerNotification() {


        for (IShape newObserver : observers) {
            newObserver.updateShapeList();
        }
    }


    public void add_SelectedList(IShapeInterface shapes) {
        selectedShapesList.add(shapes);

    }

    public void selected_ListRemove() {
        selectedShapesList.removeAll(selectedShapesList);
        observerNotification();

    }

    public void selectedShapeListClear() {
        selectedShapesList.clear();
    }

    public ArrayList<IShapeInterface> get_SelectedShapesList() {
        return selectedShapesList;
    }

    //Shape list clipboard

    public void add_ShapesToClipboard(IShapeInterface shapes) {
        clipBoard.add(shapes);

    }

    public void remove_ClipBoardShapes() {
        clipBoard.removeAll(selectedShapesList);
        observerNotification();

    }

    public void clear_ClipBoard() {
        clipBoard.clear();
    }

    public ArrayList<IShapeInterface> get_ClipBoardShapes() {
        return clipBoard;
    }


}

