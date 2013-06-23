package com.digitwolf.cmyk.client.presenter;

import com.digitwolf.cmyk.client.controllers.DataController;
import com.digitwolf.cmyk.client.events.navigation.ShowAddMachineDialogEvent;
import com.digitwolf.cmyk.client.models.Machine;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

public class MachineEditPresenter extends WidgetPresenter<MachineEditPresenter.Display> {


    private DataController dataController;

    /**
     * Creates a new machine and opens a modal window to edit it.
     */
    public void createNewMachine() {
        editMachine(new Machine());
    }

    /**
     * Open the machine editor window
     * @param machine entity to update
     */
    public void editMachine(Machine machine) {
        getDisplay().bindEditor(machine);
        getDisplay().show();
    }

    public interface Display extends WidgetDisplay{
		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
		void bindEditor(Machine machine);
		Machine getFlush();
		
		void show();
		void hide();
	}

	@Inject
	public MachineEditPresenter(final Display display, final EventBus eventBus,
                                final DataController dataController) {
		super(display, eventBus);
		bind();
        this.dataController = dataController;
    }

	
	@Override
	protected void onBind() {
		registerHandler(eventBus.addHandler(ShowAddMachineDialogEvent.TYPE, new ShowAddMachineDialogEvent.Handler() {
            @Override
            public void ShowAddMachineDialog(ShowAddMachineDialogEvent event) {
                display.show();
            }
        }));

        registerHandler(getDisplay().getSaveButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //TODO implement
                dataController.addMachine(getDisplay().getFlush());
                getDisplay().hide();
            }
        }));

        registerHandler(getDisplay().getCancelButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //TODO implement
                getDisplay().hide();
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
