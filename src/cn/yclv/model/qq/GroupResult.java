package cn.yclv.model.qq;

import java.util.List;

public class GroupResult {
	private List<Group> create;
	private Integer ec;
	private List<Group> join;
	private List<Group> manage;

	public List<Group> getCreate() {
		return create;
	}

	public void setCreate(List<Group> create) {
		this.create = create;
	}

	public Integer getEc() {
		return ec;
	}

	public void setEc(Integer ec) {
		this.ec = ec;
	}

	public List<Group> getJoin() {
		return join;
	}

	public void setJoin(List<Group> join) {
		this.join = join;
	}

	public List<Group> getManage() {
		return manage;
	}

	public void setManage(List<Group> manage) {
		this.manage = manage;
	}

}
