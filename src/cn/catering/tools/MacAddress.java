package cn.catering.tools;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MacAddress {
	public static byte[] getMACAddr(){
		try {
			//获取ip
			NetworkInterface netInterface =NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			// 获得Mac地址的byte数组
			return netInterface.getHardwareAddress();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}
