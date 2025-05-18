package com.andkantor.notificationfunction;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification.S3ObjectEntity;

public class NotificationFunction implements RequestHandler<S3Event, String>{
    
    private final SnsHandler snsHandler = new SnsHandler();

    public NotificationFunction() {
        System.out.println("NotificationFunction initialized");
    }

    @Override
    public String handleRequest(S3Event event, Context context) {
        S3ObjectEntity object = event.getRecords().get(0).getS3().getObject();
        snsHandler.sendNotification(
            "AWS Lambda Image upload notification", 
            "Hi, a new image has been uploaded." + 
            "\n\nKey: " + object.getKey() +
            "\n\nSize: " + object.getSizeAsLong());

        System.out.println("Notification sent for image: " + object.getKey());

        return "Success!";
    }
}
