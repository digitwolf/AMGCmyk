package com.digitwolf.cmyk.client.modules.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;

import com.digitwolf.cmyk.client.DataService;
import com.digitwolf.cmyk.client.DataServiceAsync;
import com.digitwolf.cmyk.client.UserService;
import com.digitwolf.cmyk.client.UserServiceAsync;
import com.digitwolf.cmyk.client.impl.avatar.GravatarServiceProvider;
import com.digitwolf.cmyk.client.presenter.AppPresenter;
import com.digitwolf.cmyk.client.presenter.MachineEditPresenter;
import com.digitwolf.cmyk.client.presenter.MachinesPresenter;
import com.digitwolf.cmyk.client.presenter.MainPresenter;
import com.digitwolf.cmyk.client.presenter.MenuPresenter;
import com.digitwolf.cmyk.client.presenter.UserThumbPresenter;
import com.digitwolf.cmyk.client.service.AvatarService;
import com.digitwolf.cmyk.client.view.MachineEditView;
import com.digitwolf.cmyk.client.view.MachinesView;
import com.digitwolf.cmyk.client.view.MainView;
import com.digitwolf.cmyk.client.view.MenuView;
import com.digitwolf.cmyk.client.view.UserThumbView;
import com.google.inject.Singleton;


public class CmykClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
    	//bind(PlaceManager.class).in(Singleton.class);
        bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
        //bind(PlaceManager.class).in(Singleton.class);
        //bind(ILog.class).to(GwtLogAdapter.class).in(Singleton.class);
        bind(AppPresenter.class);

        bind(MainPresenter.class).in(Singleton.class);
        
        // Bind Views
        bindPresenter(MainPresenter.class, MainPresenter.Display.class, MainView.class);
        bindPresenter(MenuPresenter.class, MenuPresenter.Display.class, MenuView.class);
        bindPresenter(UserThumbPresenter.class, UserThumbPresenter.Display.class, UserThumbView.class);
        bindPresenter(MachinesPresenter.class, MachinesPresenter.Display.class, MachinesView.class);
        bindPresenter(MachineEditPresenter.class, MachineEditPresenter.Display.class, MachineEditView.class);
        
        //Export Views
//        bind(MainView.class).in(Singleton.class);
//        bind(MenuView.class).in(Singleton.class);
//        bind(MachinesList.class);
//        bind(MachinesList.class);

        //Export data services
        bind(DataServiceAsync.class);
        bind(DataService.class);
        bind(UserService.class);
        bind(UserServiceAsync.class);
        
        // REGISTER SERVICE PROVIDERS
        // Avatar Service
        bind(AvatarService.class).to(GravatarServiceProvider.class).in(Singleton.class);
    }
}
