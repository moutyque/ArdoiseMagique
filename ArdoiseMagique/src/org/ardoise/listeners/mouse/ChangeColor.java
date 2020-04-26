package org.ardoise.listeners.mouse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ardoise.views.fenetres.Fenetre;

public class ChangeColor implements ActionListener {

	private final Fenetre fen;
	private final Color color;
	
	public ChangeColor(Fenetre fen, Color color) {
		this.fen = fen;
		this.color = color;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.fen.getPan().setColor(color);

	}

}
