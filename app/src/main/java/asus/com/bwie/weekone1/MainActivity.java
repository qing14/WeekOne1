package asus.com.bwie.weekone1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.Map;

import asus.com.bwie.weekone1.adapter.ListAdapter;
import asus.com.bwie.weekone1.bean.ShopBean;
import asus.com.bwie.weekone1.presenter.PresenterImpl;
import asus.com.bwie.weekone1.view.IView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.XRecycle)
    XRecyclerView xRecyclerView;
    private PresenterImpl presenter;
    private int num=2;
    private ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);
        presenter = new PresenterImpl(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,num);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(gridLayoutManager);

        presenter.onRequestGet(Apis.list+"?keyword=手机&page=1&count=10",ShopBean.class);
        listAdapter = new ListAdapter(this);
        xRecyclerView.setAdapter(listAdapter);
    }





    @Override
    public void onSuccessData(Object data) {
        if (data instanceof ShopBean){
            ShopBean shopBean = (ShopBean) data;
            listAdapter.setResultBeans(shopBean.getResult());
        }


    }

    @Override
    public void onFailData(Exception e) {

    }
}
