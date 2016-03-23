package com.boldijar.flexibleadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private MyFlexibleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new MyFlexibleAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setDisplayHeadersAtStartUp(true);
        adapter.enableStickyHeaders(3);

        adapter.addHeaders();

    }

    @Override
    public void onBackPressed() {
        adapter.addItems();
    }
}
