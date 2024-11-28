package com.example.recyclerviewpoject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewpoject.adaptors.ClientAdaptor;
import com.example.recyclerviewpoject.data.Client;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ClientAdaptor clientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //List
        List<Client> list = new ArrayList<>(List.of(
                new Client(0, "A", "a", "111"),
                new Client(1, "B", "b", "222"),
                new Client(2, "C", "c", "333")
        ));
        //Adapter
        clientAdapter = new ClientAdaptor(this, list);
        //
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(clientAdapter);
        //LayoutManager !!!!
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        );
    }


}