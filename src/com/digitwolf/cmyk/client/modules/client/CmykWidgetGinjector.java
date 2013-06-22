package com.digitwolf.cmyk.client.modules.client;

import com.digitwolf.cmyk.client.presenter.AppPresenter;
import com.digitwolf.cmyk.client.presenter.MainPresenter;
import com.digitwolf.cmyk.client.view.MainView;
import com.digitwolf.cmyk.client.view.MenuView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created with IntelliJ IDEA.
 * User: Руслан
 * Date: 11.06.13
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
@GinModules(CmykClientModule.class)
public interface CmykWidgetGinjector extends Ginjector {
    public static final CmykWidgetGinjector Instance = GWT.create(CmykWidgetGinjector.class);

    AppPresenter getAppPresenter();
    //PlaceManager getPlaceManager();
    //PlaceHistoryHandler getPlaceHistoryHandler(+);
    
    MainPresenter getMainPresenter();
    MainView getMainView();
    MenuView getMenuView();
}
