package com.example.hp.retrofitrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hp.retrofitrecycleview.APIClient.APIClient;
import com.example.hp.retrofitrecycleview.POJO.RanksPojo;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RanksActivity extends AppCompatActivity {
    RecyclerView rank_re;
    RankAdapter rankAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<RanksPojo> ranksPojos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranks);
        initViews();
    }

    private void initViews(){
        rank_re = (RecyclerView)findViewById(R.id.rank_re);
        rank_re.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rank_re.setLayoutManager(layoutManager);

        loadJSON();
    }

    private void loadJSON(){

        APIInterface request = APIClient.getApiclient().create(APIInterface.class);
        Call<JSONResponse> call = request.getSrank();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                ranksPojos = new ArrayList<>(Arrays.asList(jsonResponse.getRanks()));
                rankAdapter = new RankAdapter(ranksPojos,getApplicationContext());
                rank_re.setAdapter(rankAdapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
