package com.example.logonrm.metrosp.api;

import com.example.logonrm.metrosp.model.Linha;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonrm on 26/06/2017.
 */

public interface API {

    @GET("/linhas")
    Call<List<Linha>> getLinhasMetro();

}
