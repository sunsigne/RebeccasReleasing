package com.sunsigne.rebeccasreleasing.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild.Game;

public class Window extends Canvas {

	private static final long serialVersionUID = 1L;

	public Window(Game game) {

		game.setMinimumSize(new Dimension(Size.WIDHT, Size.HEIGHT));
		game.setMaximumSize(new Dimension(Size.WIDHT, Size.HEIGHT));
		game.setPreferredSize(new Dimension(Size.WIDHT, Size.HEIGHT));

		ImageIcon icon = new ImageIcon("ressources/textures/icon.png");
		JFrame frame = new JFrame(Game.NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.setIconImage(icon.getImage());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.pack();
	}

}
