package org.ardoise.listeners.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.ardoise.views.panneaus.Panneau;

public class MouseDrawing implements MouseListener, MouseMotionListener{

	private Panneau pan;
	private boolean isClicked = false;
	
	public MouseDrawing(Panneau pan) {
		this.pan = pan;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
//		isClicked = true;
//		pan.addPoint(e.getPoint());
//		pan.update();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isClicked = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		isClicked= false;
		// TODO Auto-generated method stub

	}
//MouseMotionListener methode
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		pan.addPoint(e.getPoint());
		pan.update();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
