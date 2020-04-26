package org.ardoise.listeners.mouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ardoise.views.fenetres.Fenetre;

public class RoundShape implements ActionListener {

	private final Fenetre fen;
	
	public RoundShape(Fenetre fen) {
		this.fen = fen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.fen.getPan().setRoundPointer(true);

	}

}
