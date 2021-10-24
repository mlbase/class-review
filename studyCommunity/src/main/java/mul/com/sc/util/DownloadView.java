/* 이유: 다운로드는 다운로드 시에 기존 디테일 페이지는 화면에 유지한 채 창이 하나 뜨면서 다운로드가 이뤄진다. 
그리고 다운로드가 다 되어도 디테일 창은 유지된다. 고로 이런 점에서 다른 페이지들과는 차이가 있다. */
package mul.com.sc.util;

import java.io.File; 
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import mul.com.sc.service.PdsService;

// 실제 다운로드가 되는 클래스
public class DownloadView extends AbstractView{

	@Autowired
	PdsService service;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("DownloadView renderMergedOutputModel");
		
		File file = (File)model.get("downloadFile");	
		String filename = (String)model.get("filename");
		int seq = (Integer)model.get("seq");
		
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length());
		
		// 한글명 파일일 경우에 지금 설정을 안해주면 정상으로 나오지 않는다
		filename = URLEncoder.encode(filename, "utf-8");
		
		// 다운로드 창
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		// filename은 원본파일명 
		response.setHeader("Content-Transfer-Encoding", "binary;");
		// 인코딩해서 바이너리형식으로 다운로드
		response.setHeader("Content-Length", "" + file.length());
		// 파일의 길이값을 알려줌
		response.setHeader("Pragma", "no-cache;"); 
		// 파일을 저장할 것인지
		response.setHeader("Expires", "-1;");
		// 기한을 의미하는데 -1인 경우 기한없음 
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = new FileInputStream(file);
		
		// 다운로드가 실제로 완성되는 부분
		FileCopyUtils.copy(fi, out);
		
		// 다운로드 횟수를 증가
		service.pdsdowncount(seq);
		
		if(fi != null) {
			fi.close();
		}
	}
	
	

}





