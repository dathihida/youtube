package asm_java4.service;

import javax.servlet.ServletContext;

import asm_java4.enity.User;
import asm_java4.enity.Video;

public interface EmailService {
	void sendEmail(ServletContext context, User recipient,String type);
	void sendEmailVideo(ServletContext context, User recipient,Video video, String type);
}
