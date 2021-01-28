package model.interfaces;

import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public interface IShapeList {
    void add_Shape(IShapeInterface shape);

    void remove_Shape(IShapeInterface shape);

    ArrayList<IShapeInterface> get_ShapeList();

    void subscribe(IShape paintCanvas);

    void observerNotification();

}
