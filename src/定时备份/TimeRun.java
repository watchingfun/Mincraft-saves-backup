package 定时备份;

import java.util.TimerTask;

public class TimeRun extends TimerTask{
	Control c;
	TimeRun(Control c){
		this.c = c;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		c.start();
	}

}
