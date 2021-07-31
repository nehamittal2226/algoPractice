package com.factoryDesignPattern;

public class Driver {

	public static void main(String[] args) {
		NotificationFactory factory=new NotificationFactory();
		Notification notification=factory.createChannel("sms");
		notification.notifyUser();

	}

}
