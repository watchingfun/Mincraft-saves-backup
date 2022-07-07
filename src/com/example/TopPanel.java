package com.example;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton saveBtn;
	static JButton openBtn;

	TopPanel() {
		saveBtn = new JButton("源地址");
		openBtn = new JButton("目的地");
		saveBtn.setActionCommand("select1");
		openBtn.setActionCommand("select2");
		add(saveBtn);
		add(openBtn);
		Listen listen = new Listen();
		saveBtn.addActionListener(listen);
		openBtn.addActionListener(listen);
	}
	
}
