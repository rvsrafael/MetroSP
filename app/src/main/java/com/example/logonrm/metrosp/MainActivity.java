package com.example.logonrm.metrosp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.logonrm.metrosp.adapter.LinhaAdapter;
import com.example.logonrm.metrosp.api.API;
import com.example.logonrm.metrosp.api.APIUtils;
import com.example.logonrm.metrosp.model.Linha;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLinhas;
    private LinhaAdapter linhaAdpter;
    private API API;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvLinhas = (RecyclerView) findViewById(R.id.rvLinhasMetro);

        linhaAdpter = new LinhaAdapter(new ArrayList<Linha>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLinhas.setLayoutManager(layoutManager);
        rvLinhas.setAdapter(linhaAdpter);
        rvLinhas.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration
                = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        rvLinhas.addItemDecoration(itemDecoration);

        carregaDados();


    }

    private void carregaDados() {
        API = APIUtils.getAndroidAPIVersion();

        API.getLinhasMetro().enqueue(new Callback<List<Linha>>() {
            @Override
            public void onResponse(Call<List<Linha>> call, Response<List<Linha>> response) {
                if(response.isSuccessful()){
                    linhaAdpter.update(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Linha>> call, Throwable t) {

            }
        });
    }


}
