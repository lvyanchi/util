package cn.yclv.model.qq;

import com.google.gson.annotations.SerializedName;

public class Member {
	private String card;
	private Integer flag;
	private Integer g;
	@SerializedName("join_time")
	private Long joinTime;
	@SerializedName("last_speak_time")
	private Long lastSpeakTime;
	private Level lv;
	private String nick;
	private Integer qage;
	private Integer role;
	private Integer tags;
	private Long uin;
	private Group group;
	private Long groupNum;

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getG() {
		return g;
	}

	public void setG(Integer g) {
		this.g = g;
	}

	public Long getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Long joinTime) {
		this.joinTime = joinTime;
	}

	public Long getLastSpeakTime() {
		return lastSpeakTime;
	}

	public void setLastSpeakTime(Long lastSpeakTime) {
		this.lastSpeakTime = lastSpeakTime;
	}

	public Level getLv() {
		return lv;
	}

	public void setLv(Level lv) {
		this.lv = lv;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getQage() {
		return qage;
	}

	public void setQage(Integer qage) {
		this.qage = qage;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getTags() {
		return tags;
	}

	public void setTags(Integer tags) {
		this.tags = tags;
	}

	public Long getUin() {
		return uin;
	}

	public void setUin(Long uin) {
		this.uin = uin;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Long getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(Long groupNum) {
		this.groupNum = groupNum;
	}
	
	
	
}
