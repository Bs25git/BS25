package imgboard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.JDBCTemplate;
import imgboard.model.service.ImgBoardService;
import imgboard.model.vo.ImgBoard;
import member.model.vo.Member;

/**
 * Servlet implementation class ImgUploadServlet
 */
@WebServlet("/img/uploadFile")
@MultipartConfig
public class ImgUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImgUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("member")).getUserId();
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String uploadFilePath = request.getServletContext().getRealPath("img");
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, "UTF-8", new DefaultFileRenamePolicy());

		File multiFile = multi.getFile("img");
		String systemFileName = multi.getFilesystemName("img");
		//String filePath = multiFile.getPath();
		long fileSize = multiFile.length();
		String content = multi.getParameter("content");

		ImgBoard imgboard = new ImgBoard();
		imgboard.setFileName(systemFileName);
		imgboard.setFilePath("/img/"+systemFileName);
		imgboard.setFileSize(fileSize);
		imgboard.setUserId(userId);
		imgboard.setContent(content);

		int result = new ImgBoardService().uploadFile(imgboard);
		if (result > 0) {
			request.setAttribute("imgboard", imgboard);
			request.getRequestDispatcher("/img/list").forward(request, response);
		} else {
			System.out.println("업로드 실패");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
