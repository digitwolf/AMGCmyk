/**
 * 
 */
package com.digitwolf.cmyk.client.view;

import com.digitwolf.cmyk.client.models.Machine;
import com.digitwolf.cmyk.client.presenter.MachineEditPresenter.Display;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.IntegerBox;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author RyB
 *
 */
public class MachineEditView extends Composite implements Editor<Machine>, Display {

	private static MachineEditViewUiBinder uiBinder = GWT
			.create(MachineEditViewUiBinder.class);

	interface MachineEditViewUiBinder extends UiBinder<Widget, MachineEditView> {
	}
	
	interface MachineEditorDriver extends
    SimpleBeanEditorDriver<Machine, MachineEditView> {}
	
	private final MachineEditorDriver editorDriver;

	@UiField
	Modal modal;	
	
	@UiField
	TextBox nameEditor;
	
	@UiField
	TextArea descriptionEditor;
	
	// PAPAER-----------------------
	
	@UiField
	IntegerBox paperWidthMinEditor;
	
	@UiField
	IntegerBox paperWidthMaxEditor;
	
	@UiField
	IntegerBox paperHeightMinEditor;
	
	@UiField
	IntegerBox paperHeightMaxEditor;
	
	@UiField
	IntegerBox paperThickMinEditor;
	
	@UiField
	IntegerBox paperThickMaxEditor;
	
	@UiField
	IntegerBox densityMinEditor;
	
	@UiField
	IntegerBox densityMaxEditor;
	
	// PRODUCTION -------------------
	@UiField
	TextBox productionRateNameEditor;
	
	@UiField
	IntegerBox productionRateEditor;
	
	@UiField
	IntegerBox wasteRateEditor;
	
	// SETUP -----------------------
	@UiField
	CheckBox sutupRequiredEditor;
	
	@UiField
	IntegerBox setupTimeEditor;
	
	@UiField
	IntegerBox setupSheetWasteEditor;
	
	@UiField
	IntegerBox additionalCostsEditor;
	
	// BUTTONS ---------------------
	
	@UiField
	Button saveButton;
	
	@UiField
	Button cancelButton;

	@SuppressWarnings("unused")
	private Machine machine;
	
	public MachineEditView() {
		uiBinder.createAndBindUi(this);		
		editorDriver = GWT.create(MachineEditorDriver.class);
		editorDriver.initialize(this);         
	}

	@Override
	public void show() {
		this.modal.show();		
	}

	@Override
	public void hide() {
		this.modal.hide();	
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return this.saveButton;
	}


	@Override
	public HasClickHandlers getCancelButton() {
		return this.cancelButton;
	}

	@Override
	public void bindEditor(Machine machine) {
		this.machine = machine;
		editorDriver.edit(machine);		
	}


	@Override
	public Machine getFlush() {
		if(editorDriver!=null)
		{
			return editorDriver.flush();
		}else{		
			return null;
		}
	}

}
