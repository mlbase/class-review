package mul.com.sc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mul.com.sc.dto.UserDto;
import mul.com.sc.service.UserService;
import mul.com.sc.util.UserUtil;

@Controller
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService service;
	
	// Bcrypt 추가
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("UserController login()" + new Date());
		String content = "login";
		model.addAttribute("content", content);
		return "base";
	}
	
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public String regi(Model model) {
		logger.info("UserController regi()" + new Date());
		
		String content = "join";
		model.addAttribute("content", content);
		return "base";
	}
	
	@ResponseBody
	@RequestMapping(value = "emailCheck.do", method = RequestMethod.POST)
	public String emailCheck(String email) {
		logger.info("UserController emailCheck()" + new Date());
		
		String result = "";
		if(service.emailCheck(email)) {
			System.out.println("중복된 이메일 입니다");
			result = "NO";
		} else {
			System.out.println("사용 가능한 이메일 입니다");
			result = "YES";
		}
		
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "nickCheck.do", method = RequestMethod.POST)
	public String nickCheck(String nickname) {
		logger.info("UserController nickCheck()" + new Date());
		System.out.println("nickCheck");
		
		String result = "";
		if(service.nickCheck(nickname)) {
			System.out.println("중복된 닉네임 입니다");
			result = "NO";
		} else {
			System.out.println("사용 가능한 닉네임 입니다");
			result = "YES";
		}
		
		return result;
	}
	
	@RequestMapping(value = "joinAf.do", method = RequestMethod.POST)
	public String joinAf(Model model, UserDto user) {
		logger.info("UserController joinAf()" + new Date());
		
		// 들어온 비밀번호를 암호화
		String inputPwd = user.getPwd();
		String pwd = pwdEncoder.encode(inputPwd);
		user.setPwd(pwd);
		
		boolean b = service.addUser(user);
		String message = "";
		String content;
		if(!b) {
			message = "회원가입에 실패하였습니다";
			content = "join";
		}
		content = "login";
		model.addAttribute("message", message);
		model.addAttribute("content", content);
		return "base";
	}
	
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String loginAf(UserDto inputData, HttpSession session, Model model) {
		logger.info("UserController loginAf()" + new Date());
		
		String message = "";
		String content = "";
		UserDto user = service.login(inputData);
		if(user == null) {
			message = "가입되지 않은 이메일 입니다.";
			content = "login";
			model.addAttribute("content", content);
			model.addAttribute("message", message);
			return "base";
		} else if(!pwdEncoder.matches(inputData.getPwd(), user.getPwd())) {
			message = "비밀번호가 틀렸습니다.";
			content = "login";
			model.addAttribute("content", content);
			model.addAttribute("message", message);
			return "base";
		} else {
			user.setPwd("");
			session.setAttribute("login", user);
			content = "main";
		}
		return "redirect:/main.do";
	}
	@RequestMapping(value = "userDetail.do", method = RequestMethod.GET)
	public String userDetail(String userId, Model model) {
		logger.info("UserController userDetail()" + new Date());
		
		String message = "";
		String content = "";
		UserDto user = service.getUser(userId);
		
		if(user == null) {
			content = "main";
			message = "유저가 없습니다.";
		} else {
			content = "userDetail";
			model.addAttribute("user", user);
		}
		model.addAttribute("message", message);
		model.addAttribute("content", content);
		return "base";
	}
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("UserController logout()" + new Date());
		
		session.removeAttribute("login");
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "updateUser.do", method = RequestMethod.GET)
	public String updateUser(Model model) {
		logger.info("UserController updateUser()" + new Date());
		
		String content = "updateUser";
		model.addAttribute("content", content);
		return "base";
	}
	
	@RequestMapping(value = "userUpdateAf.do", method = RequestMethod.POST)
	public String userUpdateAf(UserDto user, 
			@RequestParam(value = "fileload", required = false) MultipartFile fileload, 
			HttpServletRequest req) {
		
		String fupload = req.getServletContext().getRealPath("/upload/profile");
		
		String filename = UserUtil.setNewFileName(fileload.getOriginalFilename());
		
		user.setAvatar("upload/profile/" + filename);
		
		File file = new File(fupload + "/" + filename);
		
		try {
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			service.updateUser(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "deleteUser.do", method = RequestMethod.GET)
	public String deleteUser(String id) {
		
		String message;
		
		boolean b = service.deleteUser(id);
		
		if(b) {
			message="계정이 삭제되었습니다";
		} else {
			message="계정삭제에 실패하였습니다";
		}
		
		return "redirect:/main.do";
	}
}
