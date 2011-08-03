package com.notnoop.c2dm;

/**
 * Represents both a device registration id and an {@link C2DMNotification}. 
 * 
 * @author jon
 *
 */
public class C2DMDeviceNotification {

	private final String registrationId;
	private final C2DMNotification notification;
	
	public C2DMDeviceNotification(String registrationId,
			C2DMNotification notification) {
		super();
		this.registrationId = registrationId;
		this.notification = notification;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public C2DMNotification getNotification() {
		return notification;
	}
	
}
