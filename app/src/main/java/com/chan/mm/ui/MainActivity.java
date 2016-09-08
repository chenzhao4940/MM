package com.chan.mm.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chan.mm.HomeEntity;
import com.chan.mm.HomeRecyclerAdapter;
import com.chan.mm.R;
import com.chan.mm.SpacesItemDecoration;
import com.chan.mm.callback.RecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private RecyclerView mRecycler;
    private List<HomeEntity> mDatas;
    private HomeRecyclerAdapter mAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    public void setListener() {
        mAdapter.setOnItemClickListener(new RecyclerViewItemClickListener<HomeEntity>() {
            @Override
            public void onItemClick(View itemView, int position, HomeEntity data) {
                startActivity(new Intent(mContext,PhotoActivity.class));
            }
        });
        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                staggeredGridLayoutManager.invalidateSpanAssignments();
            }
        });
    }

    public void loadDatas() {
        HomeEntity entity = new HomeEntity();
        entity.setCoversUrl("http://d.hiphotos.baidu.com/image/pic/item/43a7d933c895d143b6171f2571f082025aaf0756.jpg");
        entity.setDes("美丽漂亮你现在是我的闺蜜我以后好似孩子的干妈的小美女1");
        entity.setId(10001);
        mDatas.add(entity);

        HomeEntity entity1 = new HomeEntity();
        entity1.setCoversUrl("http://g.hiphotos.baidu.com/image/pic/item/7a899e510fb30f24a41d260aca95d143ad4b0330.jpg");
        entity1.setDes("性感看是否接受客户方长腿MM2");
        entity1.setId(10001);
        mDatas.add(entity1);

        HomeEntity entity2 = new HomeEntity();
        entity2.setCoversUrl("http://b.hiphotos.baidu.com/image/h%3D200/sign=9d02c6072b2eb938f36d7df2e56085fe/a686c9177f3e670900d880193fc79f3df9dc5578.jpg");
        entity2.setDes("清恩恩哈哈这要是哦京都洛杉矶佛阿斯科大佛阿斯发纯妹妹3");
        entity2.setId(10001);
        mDatas.add(entity2);

        HomeEntity entity3 = new HomeEntity();
        entity3.setCoversUrl("http://g.hiphotos.baidu.com/image/h%3D200/sign=b2446bcd31fa828bce239ae3cd1e41cd/0e2442a7d933c895df3977b3d31373f0830200b6.jpg");
        entity3.setDes("");
        entity3.setId(10001);
        mDatas.add(entity3);

        HomeEntity entity4 = new HomeEntity();
        entity4.setCoversUrl("http://c.hiphotos.baidu.com/image/h%3D200/sign=1f074e7222a4462361caa262a8227246/30adcbef76094b36de8a2fe5a1cc7cd98d109d99.jpg");
        entity4.setDes("美丽漂亮的水电费空间哦啊死恶劣就卧铺个噢看孙郎杜甫小美女5");
        entity4.setId(10001);
        mDatas.add(entity4);

        HomeEntity entity5 = new HomeEntity();
        entity5.setCoversUrl("http://img5.imgtn.bdimg.com/it/u=2710386802,3815297051&fm=21&gp=0.jpg");
        entity5.setDes("明星生理结构爬山屁股哦哦哦撒旦教佛我周迅6");
        entity5.setId(10001);
        mDatas.add(entity5);

        HomeEntity entity6 = new HomeEntity();
        entity6.setCoversUrl("http://img2.mingxing.com/upload/attach/2015/06-24/290765-WkOsdj.jpg");
        entity6.setDes("陈乔上岛咖啡技术了就佛阿加莎劳动法ilwshg恩7");
        entity6.setId(10001);
        mDatas.add(entity6);

        mAdapter.notifyDataSetChanged();
    }

    public void initViews() {
        mRecycler = (RecyclerView) this.findViewById(R.id.recycler);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecycler.setLayoutManager(staggeredGridLayoutManager);

        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        mRecycler.addItemDecoration(decoration);


        mDatas = new ArrayList<>();
        mAdapter = new HomeRecyclerAdapter(MainActivity.this, mDatas);
        mRecycler.setAdapter(mAdapter);
    }
}
