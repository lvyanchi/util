package cn.yclv.constrant;

public interface CommonConstant {
	
	String LBYC_STATIC_PATH = "E:\\java\\luban\\rest\\src\\main\\resources\\static\\";
	
	String LBYC_TEST = "C:\\Users\\Administrator\\Desktop\\备份\\";
	String PACKAGE_TEST_PATH = LBYC_TEST + "package.json";
	
	//匹配script标签的正则
	String SCRIPT_PATTERN = "<script[^>]*?>[\\s\\S]*?<\\/script>";
	
	//匹配包含build*.js的script标签
	String SCRIPT_PATTERN_BUILD = "<script[^>]*?build([^>]*?)\\.js([^>]?)>[\\s\\S]*?<\\/script>";
	
	//匹配包含vendor.js的script标签
	String SCRIPT_PATTERN_VENDOR = "<script[^>]*?vendors.js([^>]+)>[\\s\\S]*?<\\/script>";
	
	//index.html绝对路径
	String LBYC_INDEX_PATH = LBYC_STATIC_PATH + "html\\wx\\index.html";
	
	//package.json绝对路径
	String PACKAGE_JSON_PATH = LBYC_STATIC_PATH + "package.json";
	
	String BUILD_JS_PATH = LBYC_STATIC_PATH + "js\\build.js";
}
