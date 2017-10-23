package com.domily.android.domily.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.domily.android.domily.R;

import java.util.List;

public class TiendaAdapter extends RecyclerView.Adapter<TiendaAdapter.ViewHolder> {

    private List<String> mNombres;
    private int mLayout;
    private OnItemClickListener mItemClickListener;

    public TiendaAdapter(List<String> nombres, int layout, OnItemClickListener listener) {
        this.mNombres = nombres;
        this.mLayout = layout;
        this.mItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla la vista.
        View v = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Enlaza la vista con el Layout
        holder.bind(mNombres.get(position), mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mNombres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewNombre;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mTextViewNombre = (TextView) itemView.findViewById(R.id.textViewNombre);
        }

        public void bind(final String nombre, final OnItemClickListener listener) {
            this.mTextViewNombre.setText(nombre);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    // Obtiene la posición de el elemento en vista
                    listener.onItemClick(nombre, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String name, int position);
    }
}
