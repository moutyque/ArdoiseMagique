package org.ardoise.listeners.mouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ardoise.views.fenetres.Fenetre;

public class SquareShape implements ActionListener {

	private final Fenetre fen;
	
	public SquareShape(Fenetre fen) {
		this.fen = fen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.fen.getPan().setRoundPointer(false);

	}

}
