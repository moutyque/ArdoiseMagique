package org.ardoise.views.panneaux;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.ardoise.listeners.mouse.MouseDrawing;

public class Panneau extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1741857579197228620L;

	private List<Spline> pointsToDraw = new ArrayList<>();
	private Spline spline = new Spline();
	private Color splineColor = Color.red;

	private int size = 10;

	private boolean isRoundPointer = true;

	public Panneau() {
		super();
		this.setBackground(Color.WHITE);
		this.addMouseMotionListener(new MouseDrawing(this));
		this.addMouseListener(new MouseDrawing(this));
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.WHITE);

		Stroke stroke;
		if(isRoundPointer) {
			stroke = new BasicStroke(size, BasicStroke.CAP_ROUND , BasicStroke.JOIN_ROUND);

		}
		else{
			stroke = new BasicStroke(size, BasicStroke.CAP_SQUARE , BasicStroke.JOIN_ROUND);
		}

		g2.setStroke(stroke);
		for(Spline oldSpline : pointsToDraw) {
			drawSpline(g2, oldSpline);
		}
		drawSpline(g2, spline);



	}

	private void drawSpline(Graphics2D g2, Spline spline) {
		g2.setColor(spline.getColor());

		if(!spline.getPoints().isEmpty()) {
			Point previousPoint = spline.getPoints().get(0);
			for(Point point : spline.getPoints()) {

				g2.draw(new Line2D.Float(previousPoint, point));
				previousPoint = point;
			}
		}
	}

	public boolean isRoundPointer() {
		return isRoundPointer;
	}

	public void setRoundPointer(boolean isRoundPointer) {
		this.isRoundPointer = isRoundPointer;
	}

	public void addPoint(Point point) {
		spline.add(point);

	}

	public void update() {
		this.repaint();		
	}
	public static  int toInt(double d) {
		return (int) Math.round(d);
	}

	public void nextSpline() {
		if(!spline.getPoints().isEmpty()) {
			pointsToDraw.add(new Spline(spline));
			spline = new Spline();
		}

	}

	public void clear() {
		pointsToDraw = new ArrayList<>();
		spline = new Spline();
		this.repaint();


	}

	public void setColor(Color color) {
		spline.color = color;
		splineColor= color;
	}


	class Spline{

		private List<Point> points = new ArrayList<>();
		private Color color = Color.red;

		public Spline(Spline spline) {
			this.points = new ArrayList<Point>(spline.getPoints());
			this.color = spline.getColor();
		}

		public Spline() {
			points = new ArrayList<>();
			color = splineColor == null ? Color.red :splineColor ;
		}

		public List<Point> getPoints() {
			return points;
		}
		public void add(Point point) {
			this.getPoints().add(point);

		}
		public void setPoints(List<Point> points) {
			this.points = points;
		}
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
			splineColor = color;
		}

	}

}
