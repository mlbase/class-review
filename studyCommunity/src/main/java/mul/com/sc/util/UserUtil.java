package mul.com.sc.util;

import java.util.Date;

public class UserUtil {

	public static String setNewFileName(String filename) {
		String newfilename = "";	// 새로운 파일명
		String fileExt = "";		// 확장자명
		
		if(filename.indexOf('.') >= 0) {	// 확장자명이 있는 경우
			fileExt = filename.substring( filename.indexOf(".") );
			newfilename = new Date().getTime() + fileExt;
		} else {							// 확장자명이 없는 경우
			newfilename = new Date().getTime() + ".back";
		}
		
		return newfilename;
	}
}
