package com.digitwolf.cmyk.client.view;

import com.digitwolf.cmyk.client.models.Machine;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.ModalFooter;
import com.github.gwtbootstrap.client.ui.Tab;
import com.github.gwtbootstrap.client.ui.TabPanel;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class MachineEditModal extends Modal implements Editor<Machine> {
	
	public interface Driver extends SimpleBeanEditorDriver<Machine, MachineEditModal> {}
	
	private TabPanel tabPanel;
	private Tab generalTab;
	private TextBox nameEditor;
	private TextArea descriptionEditor;
	
	
	private Tab paperTab;
	private Tab productionTab;
	
	private ModalFooter footer;
	private Button saveButton;
	private Button cancelButton;
	
	public MachineEditModal() {
		this.footer = new ModalFooter();
		
		this.tabPanel = new TabPanel();
		this.generalTab = new Tab();
		this.generalTab.setHeading("Основные");
		
		this.nameEditor = new TextBox();
		this.generalTab.add(this.nameEditor);
		
		this.descriptionEditor = new TextArea();
		this.generalTab.add(this.descriptionEditor);
		
		
		
		this.paperTab = new Tab();
		this.paperTab.setHeading("Бумага");
		
		this.productionTab = new Tab();
		this.productionTab.setHeading("Производство");
		
		this.tabPanel.add(generalTab);
		this.tabPanel.add(paperTab);
		this.tabPanel.add(productionTab);
		
		this.add(tabPanel);
		
		this.add(footer);
		saveButton = new Button("Сохранить", IconType.SAVE, new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		footer.add(saveButton);
		
		cancelButton = new Button("Отмена", IconType.OFF, new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});
		footer.add(cancelButton);
	}
}
