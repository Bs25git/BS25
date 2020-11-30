/*
 * package reservation.controller;
 * 
 * import java.io.IOException; import java.util.Date; import
 * java.util.Properties;
 * 
 * import javax.mail.Authenticator; import javax.mail.Message; import
 * javax.mail.MessagingException; import javax.mail.PasswordAuthentication;
 * import javax.mail.Session; import javax.mail.internet.AddressException;
 * import javax.mail.internet.InternetAddress; import
 * javax.mail.internet.MimeMessage; import javax.servlet.RequestDispatcher;
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/mail") public class ReservationServlet extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public ReservationServlet() { super(); // TODO Auto-generated constructor
 * stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * request.setCharacterEncoding("utf-8"); Reservation reserv = new
 * Reservation();
 * 
 * 
 * Properties props = System.getProperties(); props.put("mail.smtp.user",
 * "sooyn96"); props.put("mail.smtp.host", "smt.gmail.com");
 * props.put("mail.smtp.port", "465"); props.put("mail.smtp.starttls.enable",
 * "true"); props.put("mail.smtp.auth", "true");
 * props.put("mail.smtp.socketFactory.port", "465");
 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 * props.put("mail.smtp.socketFactory.fallback", "false");
 * 
 * Authenticator auth = new MyAuthentication();
 * 
 * // session 생성 및 MimeMessage 생성 Session session =
 * Session.getDefaultInstance(props, auth); MimeMessage msg = new
 * MimeMessage(session);
 * 
 * try { msg.setSentDate(new Date()); InternetAddress from = new
 * InternetAddress("sooyn96@gmail.com");
 * 
 * // 이메일 발신자 msg.setFrom(from);
 * 
 * // 이메일 수신자 String email = request.getParameter("email"); InternetAddress to =
 * new InternetAddress(email); msg.setRecipient(Message.RecipientType.TO, to);
 * 
 * // 이메일 제목 msg.setSubject("예약 확정 이메일", "utf-8");
 * 
 * // email content String dateReserved= request.getParameter("reserveDate");
 * request.setAttribute("dateReserved", dateReserved); msg.setText(dateReserved,
 * "UTF-8");
 * 
 * // 이메일 헤더 msg.setHeader("content-Type", "text/html");
 * 
 * // mail - sender javax.mail.Transport.send(msg);
 * 
 * 
 * } catch (AddressException addr_e) { addr_e.printStackTrace(); } catch
 * (MessagingException msg_e) { msg_e.printStackTrace(); } RequestDispatcher rd
 * = request.getRequestDispatcher("/index.jsp"); rd.forward(request, response);
 * } public class MyAuthentication extends Authenticator {
 * PasswordAuthentication pa;
 * 
 * public MyAuthentication() { String id = "sooyn96"; String pw = "3565566kK!";
 * 
 * pa = new PasswordAuthentication(id, pw); } public PasswordAuthentication
 * getPasswordAuthentication() { return pa; } }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */