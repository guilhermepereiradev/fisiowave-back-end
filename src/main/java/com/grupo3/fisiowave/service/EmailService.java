package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.dto.EmailDto;
import com.grupo3.fisiowave.service.exception.ValidateException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final Configuration freeMarkerConfig;

    @Value("${spring.mail.username}")
    private String sender;

    public void send(EmailDto emailDto) {
        try {
            mailSender.send(createMimeMessage(emailDto));
        } catch (Exception e) {
            throw new ValidateException(e.getMessage());
        }
    }

    public String processTemplate(String body, Map<String, Object> variables) {
        try {
            Template template = freeMarkerConfig.getTemplate(body);

            return FreeMarkerTemplateUtils.processTemplateIntoString(template, variables);
        } catch (Exception e) {
            throw new ValidateException(e.getMessage());
        }
    }

    private MimeMessage createMimeMessage(EmailDto emailDto) throws MessagingException {
        String body = processTemplate(emailDto.getBody(), emailDto.getVariables());

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        helper.setTo(emailDto.getRecipient());
        helper.setSubject(emailDto.getSubject());
        helper.setText(body, true);
        helper.setFrom(sender);

        return mimeMessage;
    }
}
