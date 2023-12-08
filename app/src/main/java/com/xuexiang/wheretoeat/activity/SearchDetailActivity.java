/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.wheretoeat.activity;

import static com.xuexiang.xui.XUI.getContext;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xuexiang.wheretoeat.R;
import com.xuexiang.wheretoeat.adapter.base.broccoli.BroccoliSimpleDelegateAdapter;
import com.xuexiang.wheretoeat.adapter.base.delegate.SimpleDelegateAdapter;
import com.xuexiang.wheretoeat.adapter.entity.Canteen;
import com.xuexiang.wheretoeat.adapter.entity.NewInfo;
import com.xuexiang.wheretoeat.utils.CanteenRepository;
import com.xuexiang.wheretoeat.utils.DemoDataProvider;
import com.xuexiang.wheretoeat.utils.Utils;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;
import com.xuexiang.xui.utils.XToastUtils;
import com.xuexiang.xui.widget.imageview.RadiusImageView;


import java.util.ArrayList;
import java.util.List;

import me.samlss.broccoli.Broccoli;

/**
 * 程序主页面,只是一个简单的Tab例子
 *
 * @author xuexiang
 * @since 2019-07-07 23:53
 */
public class SearchDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // TODO 后期需要换为从服务器拉取的数据


        CanteenRepository dataRepository = CanteenRepository.getInstance();

        List<Canteen> recycleList = dataRepository.getDataList();
        RecyclerView CanteenRecyclerView = findViewById(R.id.recyclerview);

        CanteenAdapter canteenAdapter = new CanteenAdapter(recycleList);


        LinearLayoutManager layoutManager = new LinearLayoutManager(SearchDetailActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setStackFromEnd(false);
        CanteenRecyclerView.setLayoutManager(layoutManager);
        CanteenRecyclerView.setAdapter(canteenAdapter);

    }


    class CanteenAdapter extends RecyclerView.Adapter<CanteenViewHoder> {

        public List<Canteen> canteenList;

        public CanteenAdapter(List<Canteen> canteenList) {
            this.canteenList = canteenList;
        }

        @NonNull
        @Override
        public CanteenViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_search_item,parent,false);
//            View view = View.inflate(SearchDetailActivity.this, R.layout.adapter_search_item, parent);
            CanteenViewHoder canteenViewHoder = new CanteenViewHoder(view);
            return canteenViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull CanteenViewHoder holder, int position) {
            Canteen canteen = canteenList.get(position);
            holder.mName.setText(canteen.name);
            holder.mImg.setImageResource(canteen.imgPath);
//            holder.mLocation.setText(canteen.location);
            holder.mDescription.setText(canteen.description);
//            holder.mNum.setText(canteen.num);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    XToastUtils.toast("图标");
                }
            });

        }

        @Override
        public int getItemCount() {
            return canteenList.size();
        }
    }

    class CanteenViewHoder extends RecyclerView.ViewHolder {
        TextView mName;
        RadiusImageView mImg;
//        TextView mLocation;
        TextView mDescription;
//        TextView mNum;


        public CanteenViewHoder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.iv_shopImage);
            mImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(SearchDetailActivity.this, CanteenDetailActivity.class);
//                    intent.putExtra("key","value");
//                    // TODO
//                    startActivity(intent);
                }
            });
            mName = itemView.findViewById(R.id.tv_shopName);
//            mLocation = itemView.findViewById(R.id.textView4);
            mDescription = itemView.findViewById(R.id.tv_shopDescription);
//            mNum = itemView.findViewById(R.id.textView6);
        }
    }

}
