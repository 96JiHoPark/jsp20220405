package app01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import java.sql.Statement;

import app01.dto.BoardDto;

public class BoardDao {
	// dto : data transfer object
	public boolean insert(Connection con, BoardDto dto) {
		String sql = "INSERT INTO Board (title, body, inserted) "
				+ "VALUES (?, ?, ?)";
		
		int result = 0;
		// connection
		// statment
		try(PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getBody());
			
			// LocalDate 날짜
			// LocalDateTime 날짜 시간
			LocalDateTime now = LocalDateTime.now();
			pstmt.setTimestamp(3, Timestamp.valueOf(now));
			
			// execute query
			result = pstmt.executeUpdate();
			
			// 자동 생성된 키 얻기
			try (ResultSet rs = pstmt.getGeneratedKeys();) {
				if (rs.next()) {
//								System.out.println(rs.getInt(1));
					dto.setId(rs.getInt(1));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 결과 return
		return result == 1;
	}

	public List<BoardDto> list(Connection con) {
		List<BoardDto> list = new ArrayList<>();
		
		String sql = "SELECT b.id, b.title, b.inserted, COUNT(r.id) numOfReply "
				+ "FROM Board b LEFT JOIN Reply r ON b.id = r.board_id "
				+ "GROUP BY b.id "
				+ "ORDER BY b.id DESC";
		
		try(Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				BoardDto board = new BoardDto();
				board.setId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setInserted(rs.getTimestamp(3).toLocalDateTime());
				board.setNumOfReply(rs.getInt(4));
				
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BoardDto get(Connection con, int id) {
		String sql = "SELECT b.id, b.title, b.body, b.inserted, COUNT(r.id) numOfReply "
				+ "FROM Board b LEFT JOIN Reply r ON b.id = r.board_id "
				+ "WHERE b.id = ? ";
		
		try(PreparedStatement stmt = con.prepareStatement(sql);){
			stmt.setInt(1, id);
			
			try(ResultSet rs = stmt.executeQuery();){
				if(rs.next()) {
					BoardDto board = new BoardDto();
					board.setId(rs.getInt(1));
					board.setTitle(rs.getString(2));
					board.setBody(rs.getString(3));
					board.setInserted(rs.getTimestamp(4).toLocalDateTime());
					board.setNumOfReply(rs.getInt(5));
					
					return board;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean modify(Connection con, BoardDto board) {
		String sql = "UPDATE Board "
				+ "SET title=?, "
				+ "		body=? "
				+ "WHERE id=? ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getBody());
			pstmt.setInt(3, board.getId());
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean delete(Connection con, int id) throws SQLException {
		String sql = "DELETE FROM Board "
				+ "WHERE id = ? ";
				
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
			
		int count = pstmt.executeUpdate();
		return count == 1;
	}
}
