package view.gui;

import model.interfaces.IShape;
import model.interfaces.IShapeList;
import view.interfaces.IShapeInterface;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas  extends JComponent implements IShape {
    private final IShapeList shapelist;

    public PaintCanvas(IShapeList shapelist) {
        this.shapelist = shapelist;
        shapelist.subscribe(this);
    }

    @Override
    public void updateShapeList() {

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (IShapeInterface shape : shapelist.getShapeList()) {
            shape.draw(g);
        }
    }
        public Graphics2D getGraphics2D() {

            return (Graphics2D)getGraphics();
        }
    }
