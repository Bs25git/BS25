package imgboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import imgboard.model.vo.ImgBoard;

public class ImgBoardDAO {
   public ImgBoardDAO() {}
      
   public int insertImg(Connection conn, ImgBoard imgboard) {
	   PreparedStatement pstmt = null; 
	   int result = 0; 
	   String query = "INSERT INTO IMAGEBOARD VALUES(?,?,?,?,SYSDATE,?)";
	   try {
		   pstmt = conn.prepareStatement(query);
		   pstmt.setString(1, imgboard.getFileName());
		   pstmt.setString(2, imgboard.getFilePath());
		   pstmt.setLong(3, imgboard.getFileSize());
		   pstmt.setNString(4, imgboard.getUserId());
		   pstmt.setString(5, imgboard.getContent());
		   result = pstmt.executeUpdate();
	   } catch(SQLException e) {
		   e.printStackTrace();
	   } finally {
		   JDBCTemplate.close(pstmt);
	   }
	   return result; 
   }
   
   public ArrayList<ImgBoard> selectImgList (Connection conn, String userId){
	   ArrayList<ImgBoard> iList = null;
	   PreparedStatement pstmt = null;
	   ResultSet rset = null;
	   
	   String query = "SELECT * FROM IMAGEBOARD WHERE FILEUSER = ?";
	   try {
		   pstmt = conn.prepareStatement(query);
		   pstmt.setNString(1, userId);
		   rset = pstmt.executeQuery();
		   iList = new ArrayList<ImgBoard>();
		   while(rset.next()) {
			   ImgBoard imgboard = new ImgBoard();
			   imgboard.setFileName(rset.getNString("SAVEFILENAME"));
			   imgboard.setFilePath(rset.getNString("FILEPATH"));
			   imgboard.setFileSize(rset.getLong("FILESIZE"));
			   imgboard.setUserId(rset.getNString("FILEUSER"));
			   imgboard.setRegDate(rset.getDate("REGDATE"));
			   imgboard.setContent(rset.getNString("CONTENT"));
			   iList.add(imgboard);
		   }
		   
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		 JDBCTemplate.close(pstmt);
		 JDBCTemplate.close(rset);
	   }
	   return iList;
   }

   public int deleteFile(Connection conn, String filePath, String fileUser) {
      int result = 0;
      PreparedStatement pstmt = null; 
      String query = "DELETE FROM FILETBL WHERE FILEPATH = ? AND FILEUSER = ?";
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(2, fileUser);
         pstmt.setString(1, filePath);
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(pstmt);
      }
      return result; 
   }
}