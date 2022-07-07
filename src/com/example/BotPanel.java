package com.example;

import java.awt.GridLayout;

import javax.swing.*;

public class BotPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel j1, j2;
	static JButton btn;
	static JCheckBox ck;

	BotPanel() {
		JLabel t1 = new JLabel("源地址：", JLabel.LEFT);
		JLabel t2 = new JLabel("目的地：", JLabel.LEFT);
		JLabel my = new JLabel("by Watchingfun");
		btn = new JButton("开始");
		btn.setEnabled(false);
		j1 = new JLabel("......",JLabel.LEFT);
		j2 = new JLabel("......",JLabel.LEFT);
		ck = new JCheckBox("每5分钟备份一次");
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2, 2));
		jp1.add(t1);
		jp1.add(j1);
		jp1.add(t2);
		jp1.add(j2);
		jp1.setBorder(BorderFactory.createTitledBorder("源目录/目的地"));
		JPanel jp2 = new JPanel();
		jp2.add(btn);
		jp2.add(ck);
		JPanel jp3 = new JPanel();
		jp3.add(my);
		setLayout(new GridLayout(3, 1));
		add(jp1);
		add(jp2);
		add(jp3);
		Listen listen = new Listen();
		btn.setActionCommand("start");
		btn.addActionListener(listen);
		ck.addItemListener(listen);
	}
}
