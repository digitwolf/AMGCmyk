package com.digitwolf.cmyk.client.events;

import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class MachineCreatedEvent extends GwtEvent<MachineCreatedEvent.Handler> {

	private final Machine machine;
	
	public static final Type<Handler> TYPE = new Type<Handler>();
	 
	public MachineCreatedEvent(Machine machine) {
		super();
		this.machine = machine;
	}
	
	public interface Handler extends EventHandler {
	    void onMachineCreated(MachineCreatedEvent event);
	  }
	
	 @Override
	  public Type<Handler> getAssociatedType() {
	    return TYPE;
	  }
	
	  @Override
	  protected void dispatch(Handler handler) {
	    handler.onMachineCreated(this);
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

	  public Machine getMachine() {
		return machine;
	}

}
