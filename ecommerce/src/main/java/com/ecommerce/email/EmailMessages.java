package com.ecommerce.email;

import java.util.Map;

public class EmailMessages {
    private String to;
    private String from;
    private String subject;
    private String cc;
    private String[] ccArray;
    private String bcc;
    private String[] bccArray;
    private String replyTo;
//    private File file;
//    private String fileName;
//    private InputStreamSource inputStreamSource;
    private Map<String, String> attributesTemplate;
    private String contentType;


    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String[] getCcArray() {
        return ccArray;
    }

    public void setCcArray(String[] ccArray) {
        this.ccArray = ccArray;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String[] getBccArray() {
        return bccArray;
    }

    public void setBccArray(String[] bccArray) {
        this.bccArray = bccArray;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public Map<String, String> getAttributesTemplate() {
        return attributesTemplate;
    }

    public void setAttributesTemplate(Map<String, String> attributesTemplate) {
        this.attributesTemplate = attributesTemplate;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
