package com.example.hp.retrofitrecycleview;

import com.example.hp.retrofitrecycleview.POJO.RanksPojo;

public class JSONResponse {
    private SchemePojo[] scheme;
    private  RanksPojo[] rank;
    public SchemePojo[] getscheme() {
        return scheme;
    }

    public RanksPojo[] getRanks() {
        return rank;
    }

}
