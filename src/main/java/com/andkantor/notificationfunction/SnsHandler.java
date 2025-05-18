package com.andkantor.notificationfunction;

import software.amazon.awssdk.services.sns.SnsClient;

public class SnsHandler {

    private final String TOPIC_ARN = "arn:aws:sns:us-east-1:686255989238:Epam-UploadsNotificationTopic";

    private final SnsClient snsClient;

    public SnsHandler() {
        this.snsClient = SnsClient.create();
    }

    public void sendNotification(String subject, String message) {
        snsClient.publish(publishRequest -> publishRequest
                .topicArn(TOPIC_ARN)
                .subject(subject)
                .message(message));
    }
}
