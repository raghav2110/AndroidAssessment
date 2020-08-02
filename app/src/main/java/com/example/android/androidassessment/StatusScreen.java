package com.example.android.androidassessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class StatusScreen extends AppCompatActivity {
    private EditText send_Message;
    private Button sendMessageBtn;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutInflater;
    private ArrayList<CardViewMessage> cardViewMessages =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_screen);

        send_Message = findViewById(R.id.etMessage);
        sendMessageBtn = findViewById(R.id.btnSendMessage);

        cardViewMessages.add(new CardViewMessage("This Is My Assessment"));
        cardViewMessages.add(new CardViewMessage("Lets Play Some Music"));
        cardViewMessages.add(new CardViewMessage("Lets Go For A Movie"));

        recyclerView = findViewById(R.id.viewMessage);
        recyclerView.setHasFixedSize(true);
        layoutInflater = new LinearLayoutManager(this);
        adapter = new AdapterMessage(cardViewMessages);
        recyclerView.setLayoutManager(layoutInflater);
        recyclerView.setAdapter(adapter);

        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_Message.setText("");
                Toast.makeText(StatusScreen.this, "Message Sent Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
