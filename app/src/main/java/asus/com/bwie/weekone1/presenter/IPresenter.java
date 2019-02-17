package asus.com.bwie.weekone1.presenter;

import java.util.Map;

public interface IPresenter {
    void onRequestGet(String urlData,Class clazz);
    void onRequestPost(String urlData, Map<String,String> map, Class clazz);
    void onRequestPut(String urlData, Map<String,String> map,Class clazz);
    void onRequestDelete(String urlData, Map<String,String> map,Class clazz);

}
