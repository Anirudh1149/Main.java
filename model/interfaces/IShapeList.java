package model.interfaces;

import view.interfaces.IShapeInterface;

import java.util.ArrayList;

public interface IShapeList {
    void addShape(IShapeInterface shape);

    void deleteShape(IShapeInterface shape);

    ArrayList<IShapeInterface> getShapeList();

    void subscribe(IShape paintCanvas);
    void unsubscribe(IShape paintCanvas);

    void observerNotification();
    void addSelectList(IShapeInterface shapes);

    ArrayList<IShapeInterface> getSelectShapesList();

    void selectListDelete();

    void selectShapeListClear();

    void addShapesToClipboard(IShapeInterface shapes);

    void removeClipBoardShape();

    void clearClipBoard();

    ArrayList<IShapeInterface> getClipBoardShape();
}
