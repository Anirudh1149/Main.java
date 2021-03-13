package model;


import model.interfaces.IShape;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public class ShapeList implements IShapeList {
    private final ArrayList<IShapeInterface> internalShapesList;
    private final ArrayList<IShape> observers;
    private final ArrayList<IShapeInterface> selectShapesList;
    private final ArrayList<IShapeInterface> clipBoard;


    public ShapeList() {
        internalShapesList = new ArrayList<IShapeInterface>();
        observers = new ArrayList<IShape>();
        selectShapesList = new ArrayList<IShapeInterface>();
        clipBoard = new ArrayList<IShapeInterface>();

    }

    public void addShape(IShapeInterface shapes) {
        internalShapesList.add(shapes);
        observerNotification();
    }

    public void deleteShape(IShapeInterface shape) {
        internalShapesList.remove(shape);
        observerNotification();
    }

    public ArrayList<IShapeInterface> getShapeList()
    {
        return internalShapesList;
    }

    @Override
    public void subscribe(IShape observer) {
        observers.add(observer);
    }

    @Override
    public void unsubcribe(IShape observer)
    {
        observers.remove(observer);
    }

    @Override
    public void observerNotification() {


        for (IShape newObserver : observers) {
            newObserver.updateShapeList();
        }
    }


    public void add_SelectList(IShapeInterface shapes) {
        selectShapesList.add(shapes);

    }

    public void selectListDelete() {
        selectShapesList.removeAll(selectShapesList);
        observerNotification();

    }

    public void selectShapeListClear()
    {
        selectShapesList.clear();
    }

    public ArrayList<IShapeInterface> getSelectShapesList()
    {
        return selectShapesList;
    }

    public void addShapesToClipboard(IShapeInterface shapes) {
        clipBoard.add(shapes);

    }

    public void removeClipBoardShape() {
        clipBoard.removeAll(selectShapesList);
        observerNotification();

    }

    public void clearClipBoard()
    {
        clipBoard.clear();
    }

    public ArrayList<IShapeInterface> getClipBoardShape()
    {
        return clipBoard;
    }


}

