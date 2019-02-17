package asus.com.bwie.weekone1.presenter;

import java.util.Map;

import asus.com.bwie.weekone1.callback.MyCallBack;
import asus.com.bwie.weekone1.model.ModelImpl;
import asus.com.bwie.weekone1.view.IView;

public class PresenterImpl implements IPresenter{
    private ModelImpl model;
    private IView iView;

    public PresenterImpl(IView iView) {
        this.model = new ModelImpl();
        this.iView = iView;
    }

    @Override
    public void onRequestGet(String urlData,Class clazz) {
        model.onRequestGetData(urlData, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iView.onFailData(e);
            }
        });
    }

    //post
    @Override
    public void onRequestPost(String urlData, Map<String, String> map, Class clazz) {
        model.onRequestPostData(urlData, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iView.onFailData(e);
            }
        });
    }
    //put
    @Override
    public void onRequestPut(String urlData, Map<String, String> map, Class clazz) {
        model.onRequestPutData(urlData, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFail(Exception e) {
                iView.onFailData(e);
            }
        });
    }
    //delete
    @Override
    public void onRequestDelete(String urlData, Map<String, String> map, Class clazz) {
        model.onRequestDeleteData(urlData, map, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }
            @Override
            public void onFail(Exception e) {
                iView.onFailData(e);
            }
        });
    }
    //解绑
    public void detach(){
        iView=null;
        model=null;
    }
}
