package com.example;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Control {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	long startTime;
	long endTime;
	static boolean ck = false;
	BotPanel bp = (BotPanel) MainFrame.bp;
	TopPanel tp = (TopPanel) MainFrame.tp;
	Copy copy;
	File f1 = null;
	File f2 = null;

	@SuppressWarnings("static-access")
	Control(File f1, File f2, Copy copy) {

		this.f1 = f1;
		this.f2 = f2;
		bp.btn.setEnabled(false);
		//bp.ck.setEnabled(false);
		tp.saveBtn.setEnabled(false);
		tp.openBtn.setEnabled(false);
		
		this.copy = copy;

	}

	@SuppressWarnings("static-access")
	void setEnable() {
		bp.btn.setEnabled(true);
		//bp.ck.setEnabled(true);
		tp.saveBtn.setEnabled(true);
		tp.openBtn.setEnabled(true);
	    endTime=System.currentTimeMillis();
		MainFrame.ta.append(df.format(new Date())+" 复制完成。  耗时："+(endTime-startTime)+"ms"+"\n");
	}

	void start(){
		startTime=System.currentTimeMillis();
		MainFrame.ta.append(df.format(new Date())+" 开始复制..."+"\n");
		copy.start(Control.this,f1,f2);
	}
}
