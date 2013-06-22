package com.digitwolf.cmyk.client.view;


import com.digitwolf.cmyk.client.presenter.UserThumbPresenter.Display;
import com.github.gwtbootstrap.client.ui.Image;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class UserThumbView extends Composite implements Display {
	interface UserThumbViewUiBinder extends UiBinder<Widget, UserThumbView> {
    }
	
	private static UserThumbViewUiBinder ourUiBinder = GWT.create(UserThumbViewUiBinder.class);
	
	@UiField
	Label loginLabel;
	
	@UiField
	Image avatar;
	
	@UiField
	NavLink loginLink;
	
	@UiField
	NavLink exitLink;
	
	public UserThumbView() {
		initWidget(ourUiBinder.createAndBindUi(this));
	}

	@Override
	public Image getAvatar() {		
		return this.avatar;
	}

	@Override
	public HasText getLoginLabel() {		
		return this.loginLabel;
	}

	@Override
	public NavLink getLogoutLink() {
		return this.exitLink;
	}

	@Override
	public NavLink getLoginLink() {
		return this.loginLink;
	}
	
}
