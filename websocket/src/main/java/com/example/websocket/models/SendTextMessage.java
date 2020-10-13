package com.example.websocket.models;

public class SendTextMessage {
    private String messageText;
    private String destinationPhoneNumber;


    public SendTextMessage(String messageText, String destinationPhoneNumber) {
        this.messageText = messageText;
        this.destinationPhoneNumber = destinationPhoneNumber;
    }
    public SendTextMessage(){}

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getDestinationPhoneNumber() {
        return destinationPhoneNumber;
    }

    public void setDestinationPhoneNumber(String destinationPhoneNumber) {
        this.destinationPhoneNumber = destinationPhoneNumber;
    }
}
