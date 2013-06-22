package com.digitwolf.cmyk.client.presenter;

import com.digitwolf.cmyk.client.events.navigation.ShowAddMachineDialogEvent;
import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

public class MachineEditPresenter extends WidgetPresenter<MachineEditPresenter.Display> {
	
	
	public interface Display extends WidgetDisplay{
		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
		void bindEditor(Machine machine);
		Machine getFlush();
		
		void show();
		void hide();
	}

	@Inject
	public MachineEditPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void onBind() {
		registerHandler(eventBus.addHandler(ShowAddMachineDialogEvent.TYPE, new ShowAddMachineDialogEvent.Handler() {
            @Override
            public void ShowAddMachineDialog(ShowAddMachineDialogEvent event) {
                display.show();
            }
        }));
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
