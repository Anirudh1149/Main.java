package model.interfaces;

import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public interface IShapeList {
    void add_Shape(IShapeInterface shape);

    void remove_Shape(IShapeInterface shape);

    ArrayList<IShapeInterface> get_ShapeList();

    void subscribe(IShape paintCanvas);
    void unsubcribe(IShape paintCanvas);

    void observerNotification();
    void add_SelectedList(IShapeInterface shapes);

    ArrayList<IShapeInterface> get_SelectedShapesList();

    void selected_ListRemove();

    void selectedShapeListClear();

    void add_ShapesToClipboard(IShapeInterface shapes);

    void remove_ClipBoardShapes();

    void clear_ClipBoard();

    ArrayList<IShapeInterface> get_ClipBoardShapes();
}
