package com.digitwolf.cmyk.client.presenter;


import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.Presenter;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.digitwolf.cmyk.client.events.navigation.ShowMachinesEvent;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class MainPresenter extends WidgetPresenter<MainPresenter.Display> {

	
	
    private Presenter currentPresenter;
	private MachinesPresenter machinesPresenter;

	@Override
    protected void onBind() {
    	eventBus.addHandler(ShowMachinesEvent.TYPE, new ShowMachinesEvent.Handler() {
			
			@Override
			public void onShowMachines(ShowMachinesEvent event) {
				activatePresenter(machinesPresenter);			
			}
		});

    }

    @Override
    protected void onUnbind() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void onRevealDisplay() {
        //To change body of implemented methods use File | Settings | File Templates.
    }



    @Inject
    public MainPresenter(final Display display,
                         final EventBus eventBus,
                         final MachinesPresenter machinesPresenter) {
        super(display, eventBus);
		this.machinesPresenter = machinesPresenter;
    }

    public interface Display extends WidgetDisplay {
		HasWidgets getMainContainer();

    }
    
    public void activatePresenter(Presenter presenter){  
    	if(this.currentPresenter!=presenter){
			this.currentPresenter = presenter;	
			this.getDisplay().getMainContainer().clear();
			this.getDisplay().getMainContainer().add(((WidgetDisplay) presenter.getDisplay()).asWidget());
    	}
    }
}
