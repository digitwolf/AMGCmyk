package com.digitwolf.cmyk.client.events.navigation;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class ShowMachinesEvent extends GwtEvent<ShowMachinesEvent.Handler> {
	
	public static final Type<Handler> TYPE = new Type<Handler>();
	 
	public ShowMachinesEvent() {
		super();		
	}
	
	public interface Handler extends EventHandler {
	    void onShowMachines(ShowMachinesEvent event);
	  }
	
	 @Override
	  public Type<Handler> getAssociatedType() {
	    return TYPE;
	  }
	
	  @Override
	  protected void dispatch(Handler handler) {
	    handler.onShowMachines(this);
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
	  

}
