package cn.yclv.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileUtil {

	/**
	 * 读取txt文档，保存成string
	 * @return
	 */
	public static String readTxt(String path) {
		File file = new File(path);
		BufferedReader br;
		StringBuffer sb = new StringBuffer();
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(fis);
			br = new BufferedReader(reader);
			String lineText = null;
			while((lineText = br.readLine()) != null){
				sb.append(lineText);
			}
			br.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return sb.toString();
	}
	
	
	/**
	 * 将字符串写入到文件中
	 * @param string
	 * @param desFile
	 */
	public static void writeToFile(String str, String desFile) {
		BufferedWriter bWriter = null;
		try {
			bWriter = new BufferedWriter(new FileWriter(new File(desFile)));
			bWriter.write(str.toString());
			bWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据file列表进行插入
	 * @param path
	 */
	public static void readFilesAndInsert(String path) {
		File file = new File(path);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (File f : files) {
				if(f.isFile()){
					String name = getFileNameExcludeSuff(f);
					QQUtil.insertMembersByFile(f, name);
				}
			}
		}
	}


	/**
	 * 根据文件获取去掉后缀的文件
	 * @param f
	 * @return
	 */
	public static String getFileNameExcludeSuff(File f) {
		String name = "";
		if(f.exists()){
			name = f.getName();
			name = name.substring(0, name.indexOf("."));
		}
		return name;
	}
	
	
	
	
}
