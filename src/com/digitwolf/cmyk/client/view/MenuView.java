package com.digitwolf.cmyk.client.view;

import com.digitwolf.cmyk.client.presenter.MenuPresenter;
import com.digitwolf.cmyk.client.presenter.UserThumbPresenter;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Руслан
 * Date: 10.06.13
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class MenuView extends Composite implements MenuPresenter.Display{
    interface MenuViewUiBinder extends UiBinder<Widget, MenuView> {
    }

    private static MenuViewUiBinder ourUiBinder = GWT.create(MenuViewUiBinder.class);

    @UiField
    NavLink homeLink;

    @UiField
    NavLink machinesLink;
  
    @UiField
    HTMLPanel userInfoPanel;
    
    @UiHandler("homeLink")
    public void homeClick(ClickEvent event) {

    }

    @UiHandler("machinesLink")
    public void machinesClick(ClickEvent event) {

    }

    @Inject
    public MenuView(final UserThumbPresenter userThumbPresenter) {
        initWidget(ourUiBinder.createAndBindUi(this));
        
        userThumbPresenter.bind();
        userInfoPanel.add(userThumbPresenter.getDisplay().asWidget());
    }

	@Override
	public HasClickHandlers getMachinesButton() {		
		return this.machinesLink;
	}
}