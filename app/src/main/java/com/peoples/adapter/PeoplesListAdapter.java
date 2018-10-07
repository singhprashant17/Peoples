package com.peoples.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.peoples.R;
import com.peoples.model.ApiResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PeoplesListAdapter extends RecyclerView.Adapter<PeoplesListAdapter.ViewHolder> {

    private final Context context;
    private final List<ApiResponse.Results> results;
    private final LayoutInflater inflater;
    private RecyclerViewItemClick itemClick;
    private SelectionListener selectionListener;

    public PeoplesListAdapter(Context context, List<ApiResponse.Results> results) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.results = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.result_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(results.get(position), position);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setItemClick(RecyclerViewItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public void setSelectionListener(SelectionListener selectionListener) {
        this.selectionListener = selectionListener;
    }

    public interface SelectionListener {
        void onItemSelected(View itemView, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements IViewHolderBinder<ApiResponse.Results> {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvDetail1)
        TextView tvDetail1;
        @BindView(R.id.tvDetail2)
        TextView tvDetail2;
        @BindView(R.id.tvDetail3)
        TextView tvDetail3;
        @BindView(R.id.btnReject)
        ImageButton btnReject;
        @BindView(R.id.btnAccept)
        ImageButton btnAccept;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (itemClick != null) {
                    itemClick.onItemClicked(PeoplesListAdapter.this, ViewHolder.this, getLayoutPosition());
                }
            });
        }

        @Override
        public void bind(ApiResponse.Results data, int position) {
            ImageLoader.getInstance().displayImage(data.getPicture().getLarge(), imageView);
            tvName.setText(data.getName().getFullName());
            final String age = String.valueOf(data.getDob().getAge());
            final String city = data.getLocation().getCity();
            tvDetail1.setText(age + " years, from " + city);
            tvDetail2.setText("Contact : " + data.getPhone());
            tvDetail3.setText("Email : " + data.getEmail());
        }

        @OnClick(R.id.btnReject)
        void onBtnRejectClick() {
            if (selectionListener != null) {
                selectionListener.onItemSelected(itemView, getLayoutPosition());
            }
        }

        @OnClick(R.id.btnAccept)
        void onBtnAcceptClick() {
            if (selectionListener != null) {
                selectionListener.onItemSelected(itemView, getLayoutPosition());
            }
        }
    }
}
