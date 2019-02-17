package asus.com.bwie.weekone1.model;

import com.google.gson.Gson;

import java.util.Map;

import asus.com.bwie.weekone1.callback.MyCallBack;
import asus.com.bwie.weekone1.utils.RetrofitUtils;

public class ModelImpl implements Imodel {


    @Override
    public void onRequestGetData(String urlData, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().get(urlData, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    @Override
    public void onRequestPostData(String urlData, Map<String, String> map, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().post(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }
            @Override
            public void onFail(String error) {

            }
        });
    }
    @Override
    public void onRequestPutData(String urlData, Map<String, String> map, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().put(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    @Override
    public void onRequestDeleteData(String urlData, Map<String, String> map, final Class clazz, final MyCallBack myCallBack) {
        RetrofitUtils.getRetrofitUtils().delete(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if (myCallBack != null) {
                        myCallBack.onSuccess(o);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    if (myCallBack != null) {
                        myCallBack.onFail(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
