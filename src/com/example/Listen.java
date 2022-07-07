package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Timer;
import javax.swing.JFileChooser;


public class Listen implements ActionListener, ItemListener {
	boolean select1 = false;
	boolean select2 = false;
	static File f1 = null;
	static File f2 = null;
	Timer timer =null;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		final JFileChooser fc = new JFileChooser();
		if (e.getActionCommand().equals("select1")) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				select1 = true;
				if (select1 == true && select2 == true)
					BotPanel.btn.setEnabled(true);
				else
					BotPanel.btn.setEnabled(false);

				f1 = fc.getSelectedFile();
				MainFrame.ta.append("目标：" + f1.getPath() + "\n");
				BotPanel.j1.setText(f1.getPath());
			} else
				MainFrame.ta.append("取消打开。\n");
		}

		else if (e.getActionCommand().equals("select2")) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				select2 = true;
				if (select1 == true && select2 == true)
					BotPanel.btn.setEnabled(true);
				else
					BotPanel.btn.setEnabled(false);

				f2 = fc.getSelectedFile();
				MainFrame.ta.append("源:  " + f2.getPath() + "\n");
				BotPanel.j2.setText(f2.getPath());
			} else
				MainFrame.ta.append("未选择。\n");
		} else if (e.getActionCommand().equals("start")) {
			Control con = new Control(f1, f2, new Copy());
			if (Control.ck == false) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						con.start();
					}

				}).start();
			}
			if(Control.ck == true){
				MainFrame.ta.append("启动定时任务。"+"\n");
				new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO 自动生成的方法存根
						timer = new Timer();
				        timer.schedule(new TimeRun(con), 0, 300*1000);
					}

				}).start();
			}
		} else
			System.exit(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自动生成的方法存根
		if (BotPanel.ck.isSelected()) {
			Control.ck = true;
		}else{
			
			Control.ck =false;
			if(timer!=null){
				timer.cancel();
				MainFrame.ta.append("定时任务取消。"+"\n");
			}
		}
	}

}
