package com.digitwolf.cmyk.client.view;

import net.customware.gwt.presenter.client.EventBus;

import com.digitwolf.cmyk.client.UserServiceAsync;
import com.digitwolf.cmyk.client.events.RecievedLoginInfoEvent;
import com.digitwolf.cmyk.client.models.LoginInfo;
import com.digitwolf.cmyk.client.presenter.MainPresenter;
import com.digitwolf.cmyk.client.presenter.MenuPresenter;
import com.github.gwtbootstrap.client.ui.Container;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Main view
 * @author RyB
 *
 */
public class MainView extends Composite implements MainPresenter.Display {

    interface MainViewUiBinder extends UiBinder<Widget, MainView> {
    }

    private static MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);
    
    @UiField
    Panel menuContainer;

    @UiField
    Container container;

	private UserServiceAsync userServiceAsync;

	private EventBus eventBus;

    @Inject
    public MainView(final MenuPresenter menu, final UserServiceAsync userServiceAsync, final EventBus eventBus) {

        this.userServiceAsync = userServiceAsync;
		this.eventBus = eventBus;
		initWidget(ourUiBinder.createAndBindUi(this));

        menuContainer.add(menu.getDisplay().asWidget());
        //container.add(machinesList);
        
    }
    @Override
    protected void onLoad() {
    	super.onLoad();
    	
    	userServiceAsync.getLoginInfo(new AsyncCallback<LoginInfo>() {
			
			@Override
			public void onSuccess(LoginInfo result) {
				eventBus.fireEvent(new RecievedLoginInfoEvent(result));
				LoginInfo.setInstance(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
    }
    
	@Override
	public HasWidgets getMainContainer() {		
		return this.container;
	}
}