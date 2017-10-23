package com.domily.android.domily.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.domily.android.domily.R;
import com.domily.android.domily.Adapters.TiendaAdapter;

import java.util.ArrayList;
import java.util.List;

public class TiendaActivity extends AppCompatActivity {

    private List<String> mNombres;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        mNombres = this.getAllNombres();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new TiendaAdapter(mNombres, R.layout.recycler_view_tienda, new TiendaAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(String name, int position) {
                Intent i = new Intent(TiendaActivity.this, ProductoActivity.class);
                startActivity(i);
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

    private List<String> getAllNombres() {
        return new ArrayList<String>() {{
           add("Tienda 1");
           add("Tienda 2");
           add("Tienda 3");
           add("Tienda 4");
        }};
    }
}
