package com.digitwolf.cmyk.client.presenter;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.digitwolf.cmyk.client.events.RecievedLoginInfoEvent;
import com.digitwolf.cmyk.client.models.LoginInfo;
import com.digitwolf.cmyk.client.service.AvatarService;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;

public class UserThumbPresenter  extends WidgetPresenter<UserThumbPresenter.Display>
	implements RecievedLoginInfoEvent.Handler {
	
	private HandlerRegistration recievedLoginInfoHandler;
	private AvatarService avatarService;

	@Inject
	public UserThumbPresenter(final Display display, final EventBus eventBus, final AvatarService avatarService) {
		super(display, eventBus);
		this.avatarService = avatarService;
	
	}

	public interface Display extends WidgetDisplay{		
		Image getAvatar();
		HasText getLoginLabel();
		
		NavLink getLogoutLink();
		NavLink getLoginLink();
	}

	@Override
	protected void onBind() {
		recievedLoginInfoHandler = eventBus.addHandler(RecievedLoginInfoEvent.TYPE, this);
		updateLoginInfoDisplay(LoginInfo.getInstance());
		
	}

	@Override
	protected void onUnbind() {
		recievedLoginInfoHandler.removeHandler();		
	}

	@Override
	protected void onRevealDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecieveLoginInfo(RecievedLoginInfoEvent event) {		
		updateLoginInfoDisplay(event.getLoginInfo());
	}
	
	private void updateLoginInfoDisplay(LoginInfo loginInfo){
		// Check if we got the data from server
		if(loginInfo==null)
		{
			// if there is no data, then hide the user widget
			this.display.asWidget().setVisible(false);
			return;
		}else
		{
			this.display.asWidget().setVisible(true);
		}
		
		this.display.getLoginLabel().setText(loginInfo.getLogin());
		
		if(loginInfo.isLoggedIn()){
			this.display.getAvatar().setVisible(true);
			this.display.getAvatar().setUrl(avatarService.getAvatarUrl(loginInfo.getEmail()));
			
			this.display.getLogoutLink().setHref(loginInfo.getLogoutUrl());
						
			this.display.getLoginLink().setVisible(false);
			this.display.getLogoutLink().setVisible(true);
		}else
		{
			this.display.getAvatar().setVisible(false);
			this.display.getLoginLink().setVisible(true);
			this.display.getLogoutLink().setVisible(false);
			
			this.display.getLoginLink().setHref(loginInfo.getLoginUrl());
		}	
	}
}
