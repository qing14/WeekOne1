package asus.com.bwie.weekone1.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import asus.com.bwie.weekone1.R;
import asus.com.bwie.weekone1.bean.ShopBean;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ShopBean.ResultBean> resultBeans=new ArrayList<>();
    private Context context;

    public ListAdapter( Context context) {
        this.resultBeans = resultBeans;
        this.context = context;
    }

    public void setResultBeans(List<ShopBean.ResultBean> resultBeans) {
        this.resultBeans = resultBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.list_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.name.setText(resultBeans.get(position).getCommodityName());
    holder.price.setText(resultBeans.get(position).getPrice());
    holder.simpleDraweeView.setImageURI(Uri.parse(resultBeans.get(position).getMasterPic()));
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView name;
        private final TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.Simple);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);


        }
    }
}
