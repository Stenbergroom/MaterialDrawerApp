package com.stenbergroom.materialdrawerapp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.*;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;


public class MainActivity extends ActionBarActivity {

    private Drawer.Result drawerResult;

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

    @Override
    public void onBackPressed() {
        if(drawerResult != null && drawerResult.isDrawerOpen()){
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void initializeNavigationDrawer(Toolbar toolbar) {

        AccountHeader.Result accHeaderResult = createAccountHeader();

        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accHeaderResult)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(initializeDrawerItems())
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        Intent intent = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(intent);
                    }
                })
                .build();
    }

    private IDrawerItem[] initializeDrawerItems() {
        return new IDrawerItem[]{new PrimaryDrawerItem()
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
                        .setDivider(false)};
    }

//    private AccountHeader.Result createAccountHeader() {
//
//        IProfile profile = new ProfileDrawerItem()
//                .withName("Stenbergroom")
//                .withEmail("stenbergroom@gmail.com")
//                .withIcon(getResources().getDrawable(R.drawable.ic_verified_user_black_18dp));
//
//        return new AccountHeader()
//                    .withActivity(this)
//                    .withHeaderBackground(R.drawable.material_background)
//                    .addProfiles(profile)
//                    .build();
//    }
}
