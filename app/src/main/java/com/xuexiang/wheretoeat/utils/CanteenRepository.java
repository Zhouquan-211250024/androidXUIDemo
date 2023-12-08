package com.xuexiang.wheretoeat.utils;

import com.xuexiang.wheretoeat.R;
import com.xuexiang.wheretoeat.adapter.entity.Canteen;

import java.util.ArrayList;
import java.util.List;

public class CanteenRepository {
    private List<Canteen> dataList;

    private static CanteenRepository instance;

    private CanteenRepository() {
        dataList = new ArrayList<Canteen>();
        dataList.add(
                new Canteen( "KBergggggggggggggggggggggggggg", R.drawable.rat, "汉口路10号", "0.0", "10")
        );
        dataList.add(
                new Canteen( "chicken", R.drawable.rat, "汉口路20号", "chicken", "10")
        );
        dataList.add(
                new Canteen( "sichu", R.drawable.rat, "汉口路30号", "依托shit", "10")
        );
        dataList.add(
                new Canteen( "quanjay", R.drawable.rat, "汉口路40号", "浓shit", "10")
        );
        dataList.add(
                new Canteen( "quanjay", R.drawable.rat, "汉口路40号", "浓shit", "10")
        );
        dataList.add(
                new Canteen( "quanjay", R.drawable.rat, "汉口路40号", "浓shit", "10")
        );
    }

    public static synchronized CanteenRepository getInstance() {
        if (instance == null) {
            instance = new CanteenRepository();
        }
        return instance;
    }

    public List<Canteen> getDataList() {
        return dataList;
    }



}