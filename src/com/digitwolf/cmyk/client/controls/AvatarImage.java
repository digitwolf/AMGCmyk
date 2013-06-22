package com.digitwolf.cmyk.client.controls;

import com.digitwolf.cmyk.client.service.AvatarService;
import com.github.gwtbootstrap.client.ui.Image;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.inject.Inject;

public class AvatarImage extends Image {
	private AvatarService avatarService;
	private String email;

	/**
     * Constructor
     * 
     * @param email
     */
	@UiConstructor
	@Inject
    public AvatarImage(final AvatarService avatarService) {
    	this.avatarService = avatarService;		
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		setUrl(avatarService.getAvatarUrl(getEmail()));
	}
}
