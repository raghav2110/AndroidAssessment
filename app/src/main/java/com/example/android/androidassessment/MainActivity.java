package com.example.android.androidassessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private RecyclerView arecyclerView,precyclerView;
    private RecyclerView.Adapter pAdapter;
    private AdapterAvailable aAdapter;
    private RecyclerView.LayoutManager alayoutManager,playoutManager;
    private ArrayList<CardViewAvailable> cardViewAvailables = new ArrayList<>();
    private ArrayList<CardViewPaired> cardViewPaireds = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewAvailables.add(new CardViewAvailable(R.drawable.ic_android,"Moto Z6 Play","Available"));
        cardViewAvailables.add(new CardViewAvailable(R.drawable.ic_laptop,"Lenovo ideapad","Available"));
        cardViewAvailables.add(new CardViewAvailable(R.drawable.ic_tv,"Mi TV","Available"));

        arecyclerView = findViewById(R.id.viewAvailable);
        arecyclerView.setHasFixedSize(true);
        alayoutManager = new LinearLayoutManager(this);
        aAdapter = new AdapterAvailable(cardViewAvailables);
        arecyclerView.setLayoutManager(alayoutManager);
        arecyclerView.setAdapter(aAdapter);

        cardViewPaireds.add(new CardViewPaired(R.drawable.ic_speaker,"BoatRockers 2110","Paired"));
        cardViewPaireds.add(new CardViewPaired(R.drawable.ic_tablet,"Samsung Tab 5","Paired"));
        cardViewPaireds.add(new CardViewPaired(R.drawable.ic_call,"Zolo s6","Paired"));

        precyclerView = findViewById(R.id.viewPaired);
        precyclerView.setHasFixedSize(true);
        playoutManager = new LinearLayoutManager(this);
        pAdapter = new AdapterPaired(cardViewPaireds);
        precyclerView.setLayoutManager(playoutManager);
        precyclerView.setAdapter(pAdapter);

        aAdapter.setOnItemClickListener(new AdapterAvailable.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position,"Connecting..");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,StatusScreen.class);
                        startActivity(intent);
                    }
                },3000);
            }
        });
    }
    public void changeItem(int position,String text){
        cardViewAvailables.get(position).changeMDeviceStatus(text);
        aAdapter.notifyItemChanged(position);
    }
}
