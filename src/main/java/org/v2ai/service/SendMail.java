package org.v2ai.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendMail {

	private MailSender mailSender;

	private String from;

	private String subject;

	public MailSender getMailSender() {
		return mailSender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String to, String msg) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(this.from);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(this.subject);
		simpleMailMessage.setText(msg);
		mailSender.send(simpleMailMessage);
	}

}