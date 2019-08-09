package com.example.demo;

import java.io.File;

/**
 * @author yanghaiyu
 * @date 2019/08/08
 **/
public class TestForhFile {
	public static void main(String[] args) {
		File file = new File("/Users/yanghaiyu/Documents");
		foreach(file);

	}

	public static void foreach(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				foreach(f);
			}
		} else {
			System.out.println(file.getPath() + "       "+file.getName());
		}
	}

}
