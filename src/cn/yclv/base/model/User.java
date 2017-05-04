package cn.yclv.base.model;

public class User {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User){
			User user = (User)obj;
			if(user.getId().equals(this.getId()) && user.getName().equals(this.getName())){
				return true;
			}
		}
		return false;
	}

}
