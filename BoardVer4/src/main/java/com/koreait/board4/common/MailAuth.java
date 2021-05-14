package com.koreait.board4.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{
	
	PasswordAuthentication pa;
    
    public MailAuth() {
        String mail_id = "goonturtle4u";
        String mail_pw = "wkdguswls123";
        
        pa = new PasswordAuthentication(mail_id, mail_pw);
    }
    
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }

}
