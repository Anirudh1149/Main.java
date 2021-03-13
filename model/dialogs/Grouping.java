package model.dialogs;

import model.Points;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import view.gui.SingletonPattern;
import view.interfaces.IShapeInterface;

import java.awt.*;
import java.util.ArrayList;



    public class Grouping implements IShapeInterface {


        private ShapeConfiguration shapeConfig;
        private ShapeShadingType shapeShadingType;
        private Color primaryColor, secondaryColor;
        private Graphics2D paint;
        private int width, height, widths, heights, AX, AY;
        private Points adjustStart, adjustEnd, startPoint, endPoint;
        private ShapeType shapeType;
        ArrayList<IShapeInterface> group = null;


        public Grouping(ShapeConfiguration shapeConfig, int i, int j, int w, int h) {
            this.shapeConfig = shapeConfig;
            this.shapeShadingType = shapeConfig.getShadingType();
            this.primaryColor = SingletonPattern.getColor(shapeConfig.getPrimaryColor());
            this.secondaryColor = SingletonPattern.getColor(shapeConfig.getSecondaryColor());
            this.width = shapeConfig.getWidth();
            this.height = shapeConfig.getHeight();
            this.adjustStart = shapeConfig.getAdjustStart();
            this.adjustEnd = shapeConfig.getAdjustEnd();
            this.startPoint = shapeConfig.getStartPoint();
            this.shapeType = shapeConfig.getShapeType();
            this.endPoint = shapeConfig.getEndPoint();
            this.widths = w;
            this.heights = h;
            this.AX = i;
            this.AY = j;
            group = new ArrayList<>();
        }


        public void addChild(IShapeInterface shape) {
            group.add(shape);
        }


        @Override
        public void draw(Graphics g) {

            paint = (Graphics2D) g;
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            paint.setStroke(stroke);
            paint.setColor(Color.BLACK);
            paint.drawRect(AX - 200, AY, widths + 20, heights + 20);
        }

        @Override
        public boolean contains(Points startPoint) {
            return (adjustStart.getI() < startPoint.getI() && adjustStart.getJ() < startPoint.getJ()
                    && adjustStart.getI() + width > startPoint.getI() && adjustStart.getJ() + height > startPoint.getJ());
        }

        @Override
        public int getWidth() {
            return width;
        }

        @Override
        public int getHeight() {
            return height;
        }

        @Override
        public Points getStartPoint() {
            return startPoint;
        }

        @Override
        public Points getEndPoint() {
            return adjustEnd;
        }

        @Override
        public void setAdjustStart(Points adjustStart) {
            this.adjustStart = adjustStart;
        }

        @Override
        public void setAdjustEnd(Points adjustEnd) {
            this.adjustEnd = adjustEnd;
        }

        @Override
        public Points getAdjustStart() {
            return adjustStart;
        }

        @Override
        public Points getAdjustEnd() {
            return adjustEnd;
        }

        @Override
        public void addI(int di) {
            adjustStart.setI(adjustStart.getI() + di);
            adjustEnd.setI(adjustEnd.getI() + di);
        }

        @Override
        public void addJ(int dj) {
            adjustStart.setJ(adjustStart.getJ() + dj);
            adjustEnd.setJ(adjustEnd.getJ() + dj);
        }


        @Override
        public ShapeConfiguration getShapeConfig() {

            return shapeConfig;
        }


    }

