package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Copy {
	static int i = 1;

	public void start(Control c, File f1, File f2) {

		copy(f1.getPath(), f2.getPath());
		c.setEnable();
	}

	@SuppressWarnings("resource")
	private static void copy(String oldPath, String newPath) {

		File a = new File(oldPath);

		String[] file = a.list();
		File temp = null;
		if (i == 1) {
			(new File(newPath + File.separator + a.getName())).mkdirs();
			newPath = newPath + File.separator + a.getName();
			i = -1;
		} else {
			(new File(newPath)).mkdirs();
		}

		for (int x = 0; x < file.length; x++) {
			if (oldPath.endsWith(File.separator)) {
				temp = new File(oldPath + file[x]);
				System.out.println(temp);
			} else {
				temp = new File(oldPath + File.separator + file[x]);
				System.out.println(temp);
			}

			if (temp.isFile()) {
				FileChannel inputChannel = null;
				FileChannel outputChannel = null;
				try {
					inputChannel = new FileInputStream(temp).getChannel();
					outputChannel = new FileOutputStream(newPath + File.separator + file[x]).getChannel();
					outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} finally {
					try {
						if (inputChannel != null)
							inputChannel.close();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					try {
						if (outputChannel != null)
							outputChannel.close();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}
			}
			if (temp.isDirectory()) {// 如果是子文件夹
				copy(oldPath + File.separator + file[x], newPath + File.separator + file[x]);
			}
		}
	}

}
