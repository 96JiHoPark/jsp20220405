package app01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import app01.dto.ReplyDto;

public class ReplyDao {
	
	public boolean insert(Connection con, ReplyDto reply) {
		String sql = "INSERT INTO Reply "
				+ "(board_id, content, inserted) "
				+ "VALUES (?, ?, ?) ";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, reply.getBoardId());
			pstmt.setString(2, reply.getContent());
			pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			
			int cnt = pstmt.executeUpdate();
			
			return cnt == 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public List<ReplyDto> list(Connection con, int boardId){
		String sql = "SELECT id, board_id, content, inserted "
				+ "FROM Reply "
				+ "WHERE board_id = ? "
				+ "ORDER BY id ";
		
		List<ReplyDto> list = new ArrayList<>();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, boardId);
			
			try(ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					ReplyDto r = new ReplyDto();
					r.setId(rs.getInt("id"));
					r.setBoardId(rs.getInt("board_id"));
					r.setContent(rs.getString("content"));
					r.setInserted(rs.getTimestamp("inserted").toLocalDateTime());
					
					list.add(r);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean update(Connection con, ReplyDto replyDto) {
		String sql = "UPDATE Reply "
				+ "SET content = ? "
				+ "WHERE id = ? ";
		
		String content = replyDto.getContent();
		int id = replyDto.getId();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, content);
			pstmt.setInt(2, id);
			
			int result = pstmt.executeUpdate();
			
			return result == 1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	public boolean delete(Connection con, int id) {
		String sql = "DELETE FROM Reply "
				+ "WHERE id = ? ";
		
		int result = 0;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result == 1;
	}

	public void deleteByBoardId(Connection con, int id) throws SQLException {
		String sql = "DELETE FROM Reply "
				+ "WHERE board_id = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
	}
	
	
}
