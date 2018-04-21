package br.com.ftec.tabhostexemplo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class ExemploTabHost extends TabActivity
        implements TabHost.OnTabChangeListener,
        TabHost.TabContentFactory {

    private static final String TAG = "ExTabHost";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getTabHost() é da TagetTabHostbActivity
        TabHost tabHost = ();
        tabHost.setOnTabChangedListener(this);

        //Tab 1 (abrir com Intent -> Activity Tab1.class)
        TabSpec tab1 = tabHost.newTabSpec("Tab 1");
        tab1.setIndicator("Tab 1",
                getResources().getDrawable(R.drawable.smile1));
        tab1.setContent(new Intent(this, Tab1.class));
        tabHost.addTab(tab1);

        //Tab 2 - Utiliza o método
        // TabContentFactory.createTabContent(String tabId)
        TabSpec tab2 = tabHost.newTabSpec("Tab 2");
        tab2.setIndicator("Tab 2", getResources().getDrawable(R.drawable.smile2));
        tab2.setContent(this); //TabContentFactory.createTabContent(String tabId)
        tabHost.addTab(tab2);

        //Tab 3 (abrir com Intent -> Activity Tab1.class)
        TabSpec tab3 = tabHost.newTabSpec("Tab 3");
        tab3.setIndicator("Tab 3");
        tab3.setContent(new Intent(this, Tab3.class));
        tabHost.addTab(tab3);


    }

    @Override
    public void onTabChanged(String tabId) {
        Log.i(TAG, "Trocou aba: " + tabId);
    }

    @Override
    public View createTabContent(String tabId) {
        TextView tv = new TextView(this);
        tv.setText("Utilizando uma factory para criar a aba: " + tabId);
        return tv;
    }
}
