package org.ardoise.views.panneaus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.ardoise.listeners.mouse.MouseDrawing;

public class Panneau extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1741857579197228620L;
	
	private List<Point> pointsToDraw = new ArrayList<>();
	private int size = 2;
	
	
	private boolean isRoundPointer = true;
	public Panneau() {
		super();

		this.setBackground(Color.RED);
		this.addMouseMotionListener(new MouseDrawing(this));

	}
	
	@Override
	public void paintComponent(Graphics g){
		
		this.setBackground(Color.RED);
		if(isRoundPointer) {
			for(Point point : pointsToDraw) {
				g.fillOval((int) Math.round(point.getX())-size/2, (int) Math.round(point.getY())-size/2, size, size);
			}
		}
		else {
			for(Point point : pointsToDraw) {
				g.fillRect((int) Math.round(point.getX())-size/2, (int) Math.round(point.getY())-size/2, size, size);
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
		pointsToDraw.add(point);
		
	}

	public void update() {
		this.repaint();		
	}

}
