package com.digitwolf.cmyk.client.events;

import com.digitwolf.cmyk.client.models.LoginInfo;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class RecievedLoginInfoEvent extends GwtEvent<RecievedLoginInfoEvent.Handler> {

	private final LoginInfo loginInfo;
	
	public static final Type<Handler> TYPE = new Type<Handler>();
	 
	public RecievedLoginInfoEvent(LoginInfo loginInfo) {
		super();
		this.loginInfo = loginInfo;
	}
	
	public interface Handler extends EventHandler {
	    void onRecieveLoginInfo(RecievedLoginInfoEvent event);
	  }
	
	 @Override
	  public Type<Handler> getAssociatedType() {
	    return TYPE;
	  }
	
	  @Override
	  protected void dispatch(Handler handler) {
	    handler.onRecieveLoginInfo(this);
	  }
	  
	  /**
	   * Register event handler
	   * @param eventBus
	   * @param handler
	   * @return
	   */
	  public static HandlerRegistration register(EventBus eventBus, Handler handler) {
		    return eventBus.addHandler(TYPE, handler);
		  }

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

}
