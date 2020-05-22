package cn.com.honzh.core;

import org.apache.shiro.crypto.hash.Md5Hash;

public class EncryptUtil {

	/**
	 * 加密
	 */
	public static String encrypt(String original,String salt){
		Md5Hash md = new Md5Hash(original+salt);
		return md.toString().toUpperCase();
	}
	
	public static void main(String[] args) {
		System.err.println(encrypt("150328", "644e93f6153d479dbca131b0b2f35625"));
	}
}
