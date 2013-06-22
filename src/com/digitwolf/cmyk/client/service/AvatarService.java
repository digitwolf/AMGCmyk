package com.digitwolf.cmyk.client.service;

/**
 * Service for getting the avatar
 * @author RyB
 *
 */
public interface AvatarService {
	/**
	 * Gets the link to the user's avatar.
	 * @param userEmail is the email of the user
	 * @return URL of the avatar
	 */
	public String getAvatarUrl(String userEmail);
}
