package mul.com.tc.util;

import java.util.Date;

public class PdsUtil {

	
	public static String setNewFileName(String filename) {
		String newfilename = "";
		
		String filepost = "";	// 확장자명
		
		if(filename.indexOf('.') >= 0) { // 확장자명이 있는 경우
			filepost = filename.substring( filename.indexOf(".") );	// abc.txt
			newfilename = new Date().getTime() + filepost;			
		}else {							// 확장자명이 없는 경우
			newfilename = new Date().getTime() + ".back";	
		}
		
		return newfilename;
	}
	
}
