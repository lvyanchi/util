package cn.yclv;

import cn.yclv.util.HttpUtil;

public class MainTest {
	private static final String GET_WXIP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=dpv97UkBCNnn4OKfUVheG_9Q0KFySbjwYrbYxGNexOWIaCF9aaT40PtBwxX1Eab2jXtv5ZjBN-RpiDp7gYzrCRBWW0lEojdzaVJmYrw1he44dLP9AXkHzJKt8f787BfQWJeAGAYER";
	public static void main(String[] args) {
		String wxIpRes = HttpUtil.buildGet(GET_WXIP_URL);
		System.out.println(wxIpRes);
	}
}
