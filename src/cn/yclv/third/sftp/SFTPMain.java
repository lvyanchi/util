package cn.yclv.third.sftp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import cn.yclv.constrant.BaseConst;
import cn.yclv.util.PropHelper;

public class SFTPMain {
	
	private static final String hostCalc = PropHelper.loadProp(BaseConst.HOST_CONFIG, "hostCalc");
	private static final String usernameCalc = PropHelper.loadProp(BaseConst.HOST_CONFIG, "usernameCalc");
	private static final String passwordCalc = PropHelper.loadProp(BaseConst.HOST_CONFIG, "passwordCalc");
	private static final String port = PropHelper.loadProp(BaseConst.HOST_CONFIG, "port");
	
	private static final String hostTest = PropHelper.loadProp(BaseConst.HOST_CONFIG, "hostTest");
	private static final String usernameTest = PropHelper.loadProp(BaseConst.HOST_CONFIG, "usernameTest");
	private static final String passwordTest = PropHelper.loadProp(BaseConst.HOST_CONFIG, "passwordTest");
	
	private static final String hostSite = PropHelper.loadProp(BaseConst.HOST_CONFIG, "hostSite");
	private static final String usernameSite = PropHelper.loadProp(BaseConst.HOST_CONFIG, "usernameSite");
	private static final String passwordSite = PropHelper.loadProp(BaseConst.HOST_CONFIG, "passwordSite");
	
	private static final String hostRest = PropHelper.loadProp(BaseConst.HOST_CONFIG, "hostRest");
	private static final String usernameRest = PropHelper.loadProp(BaseConst.HOST_CONFIG, "usernameRest");
	private static final String passwordRest = PropHelper.loadProp(BaseConst.HOST_CONFIG, "passwordRest");

    public SFTPChannel getSFTPChannel() {
        return new SFTPChannel();
    }

    public static void main(String[] args){
    	uploadToCalcServer("E:\\java\\select.html", "/root");
    }
    
    
    public static void uploadToRestServer(String src, String dest){
    	try {
			uploadToServer(hostRest, usernameRest, passwordRest, port, src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    public static void uploadToTestServer(String src, String dest){
    	try {
			uploadToServer(hostTest, usernameTest, passwordTest, port, src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    public static void uploadToSiteServer(String src, String dest){
    	try {
			uploadToServer(hostSite, usernameSite, passwordSite, port, src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    public static void uploadToCalcServer(String src, String dest){
    	try {
			uploadToServer(hostCalc, usernameCalc, passwordCalc, port, src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
	private static void uploadToServer(String host, String username, String password, String port, String src, String dest)
			throws JSchException, SftpException, FileNotFoundException, IOException, Exception {
		SFTPMain sftpMain = new SFTPMain();
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, host);
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, username);
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, password);
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, port);
              
        SFTPChannel channel = sftpMain.getSFTPChannel();
        ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
        
        OutputStream out = chSftp.put(dest, ChannelSftp.OVERWRITE); // 使用OVERWRITE模式
        byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
        int read;
        if (out != null) {
            System.out.println("Start to read input stream");
			InputStream is = new FileInputStream(src);
            do {
                read = is.read(buff, 0, buff.length);
                if (read > 0) {
                    out.write(buff, 0, read);
                }
                out.flush();
            } while (read >= 0);
            System.out.println("input stream read done.");
        }
        
        //chSftp.put(src, dst, ChannelSftp.OVERWRITE); // 代码段2
        // chSftp.put(new FileInputStream(src), dst, ChannelSftp.OVERWRITE); // 代码段3
        chSftp.quit();
        channel.closeChannel();
	}
}
