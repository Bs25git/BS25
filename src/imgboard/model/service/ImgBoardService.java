package imgboard.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import imgboard.model.dao.ImgBoardDAO;
import imgboard.model.vo.ImgBoard;

public class ImgBoardService {
   
   private JDBCTemplate factory;
   
   public ImgBoardService () {
      factory = JDBCTemplate.getConnection();
   }
   
   public int uploadFile(ImgBoard imgboard) {
      Connection conn = null;
      int result  = 0;
      
      try {
         conn = factory.createConnection();
         result = new ImgBoardDAO().insertImg(conn, imgboard);
         if(result > 0) { 
            JDBCTemplate.commit(conn);
         } else {
            JDBCTemplate.rollback(conn);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      } 
   
      return result; 
   }
   
   public ArrayList<ImgBoard> selectImgList(String userId) {
	   Connection conn = null;
	   ArrayList<ImgBoard> iList = new ArrayList<ImgBoard>();
	   try {
		   conn = factory.createConnection();
		   iList = new ImgBoardDAO().selectImgList(conn, userId);
		   
	   } catch(SQLException e) {
		   e.printStackTrace();
	   } finally {
		   JDBCTemplate.close(conn);
	   }
	   return iList;
	   
   }
   
	/*
	 * public ArrayList<FileData> selectFileList(String userId) { Connection conn =
	 * null; ArrayList<FileData> list = new ArrayList<FileData>(); try { conn =
	 * factory.createConnection(); list = new FileDAO().selectFileList(conn,
	 * userId); } catch (SQLException e) { e.printStackTrace(); } finally {
	 * JDBCTemplate.close(conn); } return list; } public int deleteFile(String
	 * filePath, String fileUser) { Connection conn = null; int result = 0;
	 * 
	 * try { conn = factory.createConnection(); result = new
	 * FileDAO().deleteFile(conn, filePath, fileUser); } catch (SQLException e) {
	 * e.printStackTrace(); } finally { JDBCTemplate.close(conn); } return result; }
	 */
      
}