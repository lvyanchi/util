package cn.yclv.model.qq;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class GroupMemberResult {
	@SerializedName("adm_max")
	private Integer admMax;
	
	@SerializedName("adm_num")
	private Integer admNum;
	
	private Integer count;
	
	private Integer ec;
	
//	private String[][] levelname;
	
	@SerializedName("max_count")
	private Integer maxCount;
	
	private List<Member> mems;
	
	@SerializedName("search_count")
	private Integer searchCount;
	
	@SerializedName("svr_time")
	private Long svrTime;
	
	private Integer vecsize;

	public Integer getAdmMax() {
		return admMax;
	}

	public void setAdmMax(Integer admMax) {
		this.admMax = admMax;
	}

	public Integer getAdmNum() {
		return admNum;
	}

	public void setAdmNum(Integer admNum) {
		this.admNum = admNum;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getEc() {
		return ec;
	}

	public void setEc(Integer ec) {
		this.ec = ec;
	}

	public Integer getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	public List<Member> getMems() {
		return mems;
	}

	public void setMems(List<Member> mems) {
		this.mems = mems;
	}

	public Integer getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(Integer searchCount) {
		this.searchCount = searchCount;
	}

	public Long getSvrTime() {
		return svrTime;
	}

	public void setSvrTime(Long svrTime) {
		this.svrTime = svrTime;
	}

	public Integer getVecsize() {
		return vecsize;
	}

	public void setVecsize(Integer vecsize) {
		this.vecsize = vecsize;
	}

//	public String[][] getLevelname() {
//		return levelname;
//	}
//
//	public void setLevelname(String[][] levelname) {
//		this.levelname = levelname;
//	}
	
	

}
