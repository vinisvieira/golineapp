package com.goline.goline.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goline.goline.R;
import com.goline.goline.model.entity.Consultorio;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class ConsultoriosRecyclerView extends RecyclerView.Adapter<ConsultoriosRecyclerView.ConsultoriosViewHolder> {

    private Context mContext;
    private Consultorio[] mConsultorios;
    private View mView;

    public ConsultoriosRecyclerView(Context context, Consultorio[] consultorios) {
            this.mContext = context;
            this.mConsultorios = consultorios;
    }

    @Override
    public ConsultoriosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.consultorio_item, parent, false);
        return new ConsultoriosViewHolder(this.mView);
    }

    @Override
    public void onBindViewHolder(ConsultoriosViewHolder holder, int position) {
        holder.setIsRecyclable(false);

        holder.textView.setText(mConsultorios[position].getNome());
    }

    @Override
    public int getItemCount() {
        return (this.mConsultorios != null && this.mConsultorios.length > 0 ? this.mConsultorios.length : 0);
    }

    public class ConsultoriosViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ConsultoriosViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewConsultorioNome);
        }
    }

}
