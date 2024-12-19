package com.appaces.ecommerce.service.email;

import com.appaces.ecommerce.dto.Product;
import com.appaces.ecommerce.enums.EmailTemplates;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.util.encoders.UTF8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.appaces.ecommerce.enums.EmailTemplates.ORDER_CONFIRMATION;
import static com.appaces.ecommerce.enums.EmailTemplates.PAYMENT_CONFIRMATION;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;


    @Async
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String userName,
            BigDecimal amount,
            String orderReference
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        messageHelper.setFrom("emmanuelbett@proton.me");
        final String templateName = PAYMENT_CONFIRMATION.getTemplate();

        Map<String,Object> variables = new HashMap<>();
        variables.put("userName",userName);
        variables.put("amount",amount);
        variables.put("orderReference",orderReference);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(PAYMENT_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName,context);
            messageHelper.setText(htmlTemplate,true);
            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info("INFO - Email successfully sent to : {} with template {}", destinationEmail, templateName);
        }catch (MessagingException e){
            log.warn("WARNING - Cannot send to email to {}",destinationEmail);
            log.error(e.getMessage());
        }
    }

    @Async
    public void sendOrderSuccessEmail(
            String destinationEmail,
            String userName,
            BigDecimal amount,
            String orderReference,
            List<Product> products
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        messageHelper.setFrom("emmanuelbett@proton.me");
        final String templateName = ORDER_CONFIRMATION.getTemplate();

        Map<String,Object> variables = new HashMap<>();
        variables.put("userName",userName);
        variables.put("totalAmount",amount);
        variables.put("orderReference",orderReference);
        variables.putIfAbsent("products",products);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(ORDER_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName,context);
            messageHelper.setText(htmlTemplate,true);
            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info("INFO - Email successfully sent to : {} with template {}", destinationEmail, templateName);
        }catch (MessagingException e){
            log.warn("WARNING - Cannot send to email to {}",destinationEmail);
            log.error(e.getMessage());
        }
    }
}