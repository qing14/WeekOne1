package asus.com.bwie.weekone1.model;

import java.util.Map;

import asus.com.bwie.weekone1.callback.MyCallBack;

public interface Imodel {

    void onRequestGetData(String urlData, Class clazz, MyCallBack myCallBack);
    void onRequestPostData(String urlData, Map<String,String> map, Class clazz, MyCallBack myCallBack);
    void onRequestPutData(String urlData, Map<String,String> map,Class clazz,MyCallBack myCallBack);
    void onRequestDeleteData(String urlData, Map<String,String> map,Class clazz,MyCallBack myCallBack);


}
