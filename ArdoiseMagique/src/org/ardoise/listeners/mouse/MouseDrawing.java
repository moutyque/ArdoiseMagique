package org.ardoise.listeners.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.ardoise.views.panneaux.Panneau;

public class MouseDrawing implements MouseListener, MouseMotionListener{

	private Panneau pan;
	
	public MouseDrawing(Panneau pan) {
		this.pan = pan;
	}
//MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {


	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pan.nextSpline();

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		pan.nextSpline();

	}
//MouseMotionListener methode
	@Override
	public void mouseDragged(MouseEvent e) {
		pan.addPoint(e.getPoint());
		pan.update();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
