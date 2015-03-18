package org.v2ai.encrypt;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RSA.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2014年12月17日 下午1:46:09
 */
public class RSAUtil {

	private String publicKey;
	private String privateKey;

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String encrypt(String data) throws Exception {
		byte[] encodedData = RSACoder.encryptByPublicKey(data.getBytes(),
				publicKey);
		return Base64.encodeBase64String(encodedData);
	}

	public String decrypt(String data) throws Exception {
		byte[] encodedData = RSACoder.decryptByPrivateKey(
				Base64.decodeBase64(data), privateKey);
		return new String(encodedData);
	}

}
