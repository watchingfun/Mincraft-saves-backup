package com.example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTextArea ta;
	static JPanel tp;
	static JPanel bp;
	public MainFrame() {
		super("MineCraft定时备份");
		

		ta = new JTextArea();
		ta.setMargin(new Insets(5, 5, 5, 5));
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);

		 tp = new TopPanel();
		tp.setBorder(BorderFactory.createTitledBorder("选择要备份的目录和目的地地址"));
		 bp = new BotPanel();
		

		Container c = getContentPane();
		c.add(tp, BorderLayout.NORTH);
		c.add(bp, BorderLayout.SOUTH);
		c.add(sp, BorderLayout.CENTER);
	}
	
	 

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 500));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
