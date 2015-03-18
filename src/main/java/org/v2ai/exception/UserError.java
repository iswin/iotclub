package org.v2ai.exception;

/**
 * @ClassName: UserException.java
 * @Description: TODO
 * @author iswin
 * @email admin@iswin.org
 * @Date 2015年3月16日 下午11:43:14
 */
public class UserError extends Error {

	private static final long serialVersionUID = 1L;

	private String msg;

	public UserError(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
