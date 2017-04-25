package com.example.yuans.testapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuans.testapplication.bean.RepoBean;
import com.example.yuans.testapplication.retrofit.GitHubServiceAPI;
import com.example.yuans.testapplication.retrofit.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxJava2DemoActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle_list)
    RecyclerView recycle_list;
    private MyAdapter myAdapter;
    private List<RepoBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java2_demo);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        recycle_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myAdapter = new MyAdapter();
        recycle_list.setAdapter(myAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Observable.just("hell rx java 2").subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Snackbar.make(toolbar, s, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });

                //获取网络数据并绑定到列表控件
                GitHubServiceAPI apiClient = RetrofitHelper.getRetrofit("https://api.github.com/").create(GitHubServiceAPI.class);
                apiClient.listRepos("yuanshuaiding").subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<List<RepoBean>>() {
                            @Override
                            public void accept(@NonNull List<RepoBean> repoBeens) {
                                beanList.clear();
                                beanList.addAll(repoBeens);
                                myAdapter.notifyDataSetChanged();
                            }
                        });
            }
        });
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_repo, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv_repo.setText(beanList.get(position).name);
        }

        @Override
        public int getItemCount() {
            return beanList.size();
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_repo)
        TextView tv_repo;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
