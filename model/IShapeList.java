package model;


import model.interfaces.IShape;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class IShapeList implements model.interfaces.IShapeList {
    private final ArrayList<IShapeInterface> internalShapesList;
    private final ArrayList<IShape> observers;
    private final ArrayList<IShapeInterface> selectedShapesList;
    private final ArrayList<IShapeInterface> clipBoard;


    public IShapeList() {
        internalShapesList = new ArrayList<>();
        observers = new ArrayList<>();
        selectedShapesList = new ArrayList<>();
        clipBoard = new ArrayList<>();

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
    public void observerNotification() {


        for (IShape newObserver : observers) {
            newObserver.updateShapeList();
        }
    }

}

