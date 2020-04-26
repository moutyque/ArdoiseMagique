package org.ardoise.views.panneaus;

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

	private List<List<Point>> pointsToDraw = new ArrayList<>();
	private List<Point> spline = new ArrayList<>();
	private int size = 2;


	private boolean isRoundPointer = true;
	public Panneau() {
		super();
		//pointsToDraw.add(spline);
		this.setBackground(Color.RED);
		this.addMouseMotionListener(new MouseDrawing(this));
		this.addMouseListener(new MouseDrawing(this));
	}

	@Override
	public void paintComponent(Graphics g){
		  Graphics2D g2 = (Graphics2D) g;
		this.setBackground(Color.RED);
		Stroke stroke = new BasicStroke();
		if(isRoundPointer) {
			stroke = new BasicStroke(size, BasicStroke.CAP_ROUND , BasicStroke.JOIN_ROUND);

		}
		else{
			stroke = new BasicStroke(size, BasicStroke.CAP_SQUARE , BasicStroke.JOIN_ROUND);
		}
		
		g2.setStroke(stroke);
		
			for(List<Point> pointsSerie : pointsToDraw) {
				drawSpline(g2, pointsSerie);
			}
			drawSpline(g2, spline);
		


	}

	private void drawSpline(Graphics2D g2, List<Point> pointsSerie) {
		if(!pointsSerie.isEmpty()) {
			Point previousPoint = pointsSerie.get(0);
			for(Point point : pointsSerie) {
				
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
		pointsToDraw.add(new ArrayList<Point>(spline));
		spline = new ArrayList<>();

	}

}
