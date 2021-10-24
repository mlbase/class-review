package mul.com.sc.util;

import java.util.Date;

public class ScUtil {

	
	public static String setNewFileName(String filename) {
		String newfilename = "";
		
		String filepost = "";	// 확장자명
		
		if(filename.indexOf('.') >= 0) { // 확장자명이 있는 경우
			filepost = filename.substring( filename.indexOf(".") );	// abc.txt
			newfilename = new Date().getTime() + filepost;			
		}
		if (filename.equals("") || filename == null) {							// 확장자명이 없는 경우
			newfilename = "";	
		}
		return newfilename;
	}
	
	public static String dot3(String title){
		String str = "";
		if(title.length() >= 30){
			str = title.substring(0, 30);
			str += "...";
		}else{
			str = title;
		}	
		return str;
	}
	
	public static String mainDot3(String title){
		String str = "";
		if(title.length() >= 19){
			str = title.substring(0, 19);
			str += "...";
		}else{
			str = title;
		}	
		return str;
	}
	
	
}
