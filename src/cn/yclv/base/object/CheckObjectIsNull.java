package cn.yclv.base.object;

import cn.yclv.base.model.User;
import cn.yclv.base.util.BeanUtils;

public class CheckObjectIsNull {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		boolean res = BeanUtils.checkValIsNull(user);
		System.out.println(res);
	}
}
