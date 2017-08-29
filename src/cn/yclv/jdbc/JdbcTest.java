package cn.yclv.jdbc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import cn.yclv.util.JdbcUtil;

public class JdbcTest {
	
	public static void main(String[] args) {
		 try {
			InetAddress localHost = InetAddress.getLocalHost();
			InetAddress[] allByName = InetAddress.getAllByName("lvyanchi");
			for (InetAddress inetAddress : allByName) {
				System.out.println(inetAddress);
			}
			System.out.println("本机的ip为：" + localHost);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void batchInsert(){
		Connection conn = JdbcUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into member values()";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
