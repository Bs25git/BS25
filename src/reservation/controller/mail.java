package reservation.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

@WebServlet("/mail")
public class mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.setCharacterEncoding("utf-8"); Reservation reserv = new
		 * Reservation();
		 */
		request.setCharacterEncoding("utf-8");
		Properties props = System.getProperties();
		props.put("mail.smtp.user", "munjicutiepie");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465"); 
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.socketFactory.fallback", "false"); 
		
		Authenticator auth = new MyAuthentication(); 
		
		// session 생성 및 MimeMessage 생성 
		Session session = Session.getDefaultInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress("munjicutiepie@gmail.com");
			
			// 이메일 발신자
			msg.setFrom(from);
			
			// 이메일 수신자
			String email = request.getParameter("email");
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			
			// 이메일 제목 
			msg.setSubject("예약 확정 이메일", "utf-8");
			
			// email content
			String name = request.getParameter("reservename");
			String dateReserved= request.getParameter("reserveDate");
			String detail = " 에 예약이 확정 되었습니다"; 
			request.setAttribute("dateReserved", dateReserved);
			msg.setText(name + "님 " + dateReserved + detail, "UTF-8");
			
			
			// 이메일 헤더
			msg.setHeader("content-Type", "text/html");
			
			// mail - sender
			javax.mail.Transport.send(msg);
			
			
		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	} 
	
	public class MyAuthentication extends Authenticator {
		PasswordAuthentication pa;
		
		public MyAuthentication() {
			String id = "munjicutiepie";
			String pw = "3565566kK!";
			
			pa = new PasswordAuthentication(id, pw);
		}
		public PasswordAuthentication getPasswordAuthentication() {
			return pa; 
		}
	}
}

