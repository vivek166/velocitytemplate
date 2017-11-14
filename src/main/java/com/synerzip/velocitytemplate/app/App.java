package com.synerzip.velocitytemplate.app;
import java.util.HashMap;
import java.util.Map;

import com.synerzip.velocitytemplate.service.MailService;
import com.synerzip.velocitytemplate.config.ApplicationConfig;
import com.synerzip.velocitytemplate.bean.Mail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

    public static void main(String args[]) {

        Mail mail = new Mail();
        mail.setMailFrom("vivek.tiwari.cse16@gmail.com");
        mail.setMailTo("vivek.tiwari.cse16@gmail.com");
        mail.setMailSubject("Spring 4 - Email with velocity template");

        Map < String, Object > model = new HashMap < String, Object > ();
        model.put("firstName", "Vivek");
        model.put("lastName", "Tiwari");
        model.put("location", "Pune");
        model.put("signature", "www.synerzip.com");
        mail.setModel(model);

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MailService mailService = (MailService) context.getBean("mailService");
        mailService.sendEmail(mail);
        context.close();
    }

}