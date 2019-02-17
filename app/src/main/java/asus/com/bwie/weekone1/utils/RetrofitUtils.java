package asus.com.bwie.weekone1.utils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import asus.com.bwie.weekone1.BaseApis;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtils {

    public static RetrofitUtils retrofitUtils;
    public String BASE_URL="http://172.17.8.100/small/";
    private final BaseApis baseApis;

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (null==retrofitUtils){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public RetrofitUtils(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        baseApis = retrofit.create(BaseApis.class);

    }

    public RetrofitUtils get(String urlData,HttpListener listener){
        baseApis.get(urlData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }
    public void post(String urlData, Map<String,String> map,HttpListener listener){
        baseApis.post(urlData, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));

    }
    public void put(String urlData, Map<String,String> map,HttpListener listener){
        baseApis.put(urlData, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));

    }
    public void delete(String urlData, Map<String,String> map,HttpListener listener){
        baseApis.delete(urlData, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));

    }




    //观察者
    public Observer getObserver(HttpListener httpListener){
        Observer observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            e.printStackTrace();
            if (listener!=null){
                listener.onFail(e.getMessage());
            }
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (listener!=null){
                        listener.onSuccess(string);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    if (listener!=null){
                        listener.onFail(e.getMessage());
                    }
                }
            }
        };
        return observer;
    }
    public HttpListener listener;

    public void setListener(HttpListener httpListener) {
        this.listener = httpListener;
    }

    public interface HttpListener{
        void onSuccess(String data);
        void onFail(String error);
    }



}
