package com.example.listas_wear_9b;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import com.example.listas_wear_9b.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Contacto> contactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WearableRecyclerView recyclerView =
                findViewById(R.id.recycler_launcher_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setEdgeItemsCenteringEnabled(true);
        recyclerView.setLayoutManager(
                new WearableLinearLayoutManager(this));

        contactos.add(
                new Contacto(R.drawable.avatars_uno, "Ivan")
        );  contactos.add(
                new Contacto(R.drawable.avatars_dos, "Eduardo")
        );

        recyclerView.setAdapter(new
                ContactosAdapter(contactos, this, new ContactosAdapter.AdapterCallback() {
            @Override
            public void onItemClicked(Integer itemPosition) {
                System.out.println(itemPosition);
                // Alerta

                switch (itemPosition){
                    case 0:
                        break;
                    case 1:
                    break;
                }
            }
        }));

    }
}