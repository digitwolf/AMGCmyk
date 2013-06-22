package com.digitwolf.cmyk.client.presenter;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.digitwolf.cmyk.client.events.navigation.ShowMachinesEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;

public class MenuPresenter extends WidgetPresenter<MenuPresenter.Display> {
	
	@Inject
	public MenuPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		bind();
	}

	public interface Display extends WidgetDisplay{
		HasClickHandlers getMachinesButton();
	}

	@Override
	protected void onBind() {
		this.display.getMachinesButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new ShowMachinesEvent());				
			}
		});
		
	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onRevealDisplay() {
		// TODO Auto-generated method stub
		
	}

}
