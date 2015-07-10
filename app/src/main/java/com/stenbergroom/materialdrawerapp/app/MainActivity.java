package com.stenbergroom.materialdrawerapp.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initializeNavigationDrawer(toolbar);
    }

    private void initializeNavigationDrawer(Toolbar toolbar) {
        Drawer.Result drawerResult = new Drawer ()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.nav_menu_item_home)
                                .withIdentifier(1)
                                .withIcon(R.drawable.ic_home_black_18dp),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.nav_menu_item_contacts)
                                .withIcon(R.drawable.ic_perm_contact_cal_black_18dp),
                        new SectionDrawerItem()
                                .withName(R.string.nav_menu_item_item_1)
                                .setDivider(false),
                        new SectionDrawerItem()
                                .withName(R.string.nav_menu_item_item_2)
                                .setDivider(false)
                )
                .build();


    }
}
