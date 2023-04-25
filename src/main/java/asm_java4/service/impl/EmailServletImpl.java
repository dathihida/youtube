package asm_java4.service.impl;

import javax.servlet.ServletContext;

import asm_java4.enity.User;
import asm_java4.enity.Video;
import asm_java4.service.EmailService;
import asm_java4.uitl.SendEmailUitl;

public class EmailServletImpl implements EmailService{

	private static final String EAMIL_WELCOME_SUBJECT = "Welcome to Online Entertainment";
	private static final String EAMIL_FORGOT_PASSWORD = "Online Entertainment - New password";
	private static final String EAMIL_SHARE_VIDEOS = "Youtube - Share Video";
	@Override
	public void sendEmail(ServletContext context, User recipient,String type) {
		// TODO Auto-generated method stub
		
        String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        
        try {
        	String content = null;
        	String subject = null;
        	
        	switch(type) {
        		case "wellcome":
        			subject = EAMIL_WELCOME_SUBJECT;
        			content = "Dear" + recipient.getUsername() + ",hope you have a good time!";
        			break;
        		case "forgot":
        			subject = EAMIL_FORGOT_PASSWORD;
        			content = "Dear" + recipient.getUsername() + ",your new password here: " +recipient.getPassword();
        			break;
        		default:
        			subject = "Online Entertaiment";
        			content = "Maybe this email is wrong, donn't care about it";
        			break;
        	}
        	SendEmailUitl.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
	}
	@Override
	public void sendEmailVideo(ServletContext context, User recipient, Video video, String type) {
		String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        
        try {
        	String content = null;
        	String subject = null;
        	
        	switch(type) {
        		case "shareVideo":
        			subject = EAMIL_SHARE_VIDEOS;
        			content = "Dear" + recipient.getUsername()+" "+ "https://youtu.be/"+video.getHref();
        			break;
        		default:
        			subject = "Online Entertaiment";
        			content = "Maybe this email is wrong, donn't care about it";
        			break;
        	}
        	SendEmailUitl.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
		
	}
}
