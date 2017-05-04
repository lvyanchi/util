package cn.yclv.constrant;

public interface QQConstrant {
	
	String INSERT_MEM_SQL_PSTMT = "insert into member (card, flag, g, join_time, last_speak_time, lv_id, qage, role, uni, nick, group_num) values(?,?,?,?,?,?,?,?,?,?,?)";

	String INSERT_MEM_SQL_STMT = "insert into member (card, flag, g, join_time, last_speak_time, lv_id, qage, role, uni, nick) values('";
	
	String INSERT_GROUP_SQL_PSTMT = "insert into `group` (gc, gn, owner) values(?,?,?)";
	
	String COMMA = ",";
}
