package com.kevinchristianson.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class FeedActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private  List<String> adapterData;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        handler = new Handler();
        linearLayoutManager = new LinearLayoutManager(FeedActivity.this);
        // return the data object
        adapterData = getFirstData();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(FeedActivity.this, adapterData, recyclerView);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnLoadMoreListener(new RecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                adapterData.add(null);
                recyclerViewAdapter.notifyItemInserted(adapterData.size() - 1);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapterData.remove(adapterData.size() - 1);
                        recyclerViewAdapter.notifyItemRemoved(adapterData.size());
                        for (int i = 0; i < 15; i++) {
                            adapterData.add("Item" + (adapterData.size() + 1));
                        recyclerViewAdapter.notifyItemInserted(adapterData.size());
                    }
                        recyclerViewAdapter.setLoaded();
                    }
                }, 2000);
                System.out.println("load");
            }
        });
    }
    private List<String> getFirstData(){
        List<String> listObject = new ArrayList<String>();
        listObject.add("Skateboard");
        listObject.add("Pencil");
        listObject.add("Life Purpose");
        listObject.add("Laptop");
        listObject.add("Morrison's - The Bluest Eye");
        listObject.add("Car for the weekend");
        listObject.add("Car for the week");
        listObject.add("Album by the Weeknd");
        listObject.add("Album by the Weeknd but not starboy pls");
        listObject.add("Record Player");
        return listObject;
    }
}
