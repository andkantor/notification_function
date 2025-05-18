package com.andkantor.notificationfunction;

// FakeTest to simulate running tests during code pipeline run.
public class FakeTest {

    public void testNotificationFunction() {
        System.out.println("Running fake test");
        throw new RuntimeException("Fake test failed");
    }
}
