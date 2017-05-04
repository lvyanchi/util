package cn.yclv.util;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;

import cn.yclv.constrant.QQConstrant;
import cn.yclv.model.qq.Group;
import cn.yclv.model.qq.GroupMemberResult;
import cn.yclv.model.qq.GroupResult;
import cn.yclv.model.qq.Member;

public class QQUtil {
	
	
	/**
	 * 按照statement进行插入数据
	 * @param mems
	 * @param stmt
	 * @throws SQLException
	 */
	public static void insertByStmt(List<Member> mems, Statement stmt) throws SQLException {
		for (Member mem : mems) {
			String sql = QQConstrant.INSERT_MEM_SQL_STMT + mem.getCard() + "'," + mem.getFlag() +
							+ mem.getFlag() + QQConstrant.COMMA + mem.getG() + QQConstrant.COMMA  + mem.getJoinTime() + QQConstrant.COMMA  + mem.getLastSpeakTime()
							+ QQConstrant.COMMA  + mem.getLv().getLevel() + QQConstrant.COMMA 
							+ mem.getQage() + QQConstrant.COMMA + mem.getRole() + QQConstrant.COMMA + mem.getUin() + ",'" + mem.getNick() +"');";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}
	}
	
	
	/**
	 * 遍历Member实例, 并执行插入操作
	 * @param mems
	 * @param conn
	 */
	public static int insertMembers(List<Member> mems, Connection conn, String sql, String groupNum){
		int count = 0;
		for (Member mem : mems) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mem.getCard());
				pstmt.setInt(2, mem.getFlag());
				pstmt.setInt(3, mem.getG());
				pstmt.setLong(4, mem.getJoinTime());
				pstmt.setLong(5, mem.getLastSpeakTime());
				pstmt.setInt(6, mem.getLv().getLevel());
				pstmt.setInt(7, mem.getQage());
				pstmt.setInt(8, mem.getRole());
				pstmt.setLong(9, mem.getUin());
				pstmt.setString(10, mem.getNick());
				pstmt.setLong(11, Long.parseLong(groupNum));
				pstmt.execute();
				count++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(sql);
		}
		return count;
	}
	
	
	/**
	 * 遍历Group实例, 并执行插入操作
	 * @param mems
	 * @param conn
	 */
	public static int insertGroups(List<Group> groups, Connection conn, String sql){
		int count = 0;
		for (Group group : groups) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, group.getGc());
				pstmt.setString(2, group.getGn());
				pstmt.setLong(3, group.getOwner());
				pstmt.execute();
				count++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(sql);
		}
		return count;
	}
	
	
	/**
	 * 获取群列表
	 * @param txtJson
	 * @return
	 */
	public static List<Group> getGroupList(String txtJson) {
		GroupResult groupResult = new Gson().fromJson(txtJson, GroupResult.class);
		List<Group> createGroup = new ArrayList<>();
		List<Group> manageGroup = new ArrayList<>();;
		List<Group> joinGroup = new ArrayList<>();;
		if(groupResult.getManage() != null){
			manageGroup = groupResult.getManage();
		}
		if(groupResult.getJoin() != null){
			joinGroup = groupResult.getJoin();
		}
		if(groupResult.getCreate() != null){
			createGroup = groupResult.getCreate();
		}
		createGroup.addAll(joinGroup);
		createGroup.addAll(manageGroup);
		return createGroup;
	}
	
	
	/**
	 * 根据File插入数据
	 * @param f
	 */
	public static int insertMembersByFile(File f, String groupNum) {
		String txtJson = FileUtil.readTxt(f.getAbsolutePath());
		txtJson = JsonUtil.handleJsonSpecialChar(txtJson);
		GroupMemberResult gmr = new Gson().fromJson(txtJson, GroupMemberResult.class);
		int resutlNums = 0;
		if(gmr != null && gmr.getMems().size() > 0){
			Connection conn = JdbcUtil.getConnection();
			resutlNums = QQUtil.insertMembers(gmr.getMems(), conn, QQConstrant.INSERT_MEM_SQL_PSTMT, groupNum);
		}
		System.out.println("共插入了" + resutlNums + "条数据");
		return resutlNums;
	}
	
	
	
	public static Long getGTK(String sKey){
		int hash = 5381;
		for (int i = 0, len = sKey.length(); i < len; ++i){
			hash += (hash << 5) + (int)sKey.indexOf(i);
		}
		return 1L;
	}
	 
	 
	public static Long getBkn(String skey)
	{
	    int hash = 5381;
	    for (int i = 0, len = skey.length(); i < len; ++i) {
	    	hash += (hash << 5) + (int)skey.indexOf(i);
	    }
	    return 2L;
	}
	
	
	
	
	
}
