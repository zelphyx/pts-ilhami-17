package com.example.tugasspts;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private ArrayList<Game> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvgamename;
        private final TextView tvgamedesc;
        private final ImageView imagepict;



        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvgamename = view.findViewById(R.id.game_name);
            tvgamedesc = view.findViewById(R.id.deskripsiawalgame);
            imagepict = view.findViewById(R.id.picture);

        }

    }

    /**
     * menginisiasi dataset yang dibuat di adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public GameAdapter(ArrayList<Game> dataSet) {localDataSet = dataSet;}

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }



    // Ganti konten tampilan (dipanggil oleh layoutmanager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        //Dapatkan elemen dari kumpulan data Anda pada posisi ini dan ganti
        // isi view dengan elemen tersebut
        String name = localDataSet.get(position).getName();
        String desc = localDataSet.get(position).getDesc();
        int image = localDataSet.get(position).getPict();
        int cover = localDataSet.get(position).getCover();


        viewHolder.tvgamename.setText(name);
        viewHolder.tvgamedesc.setText(desc);
        viewHolder.imagepict.setImageResource(image);



        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(),DetailActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("desc",desc);
                intent.putExtra("image",image);
                intent.putExtra("cover",cover);



                viewHolder.itemView.getContext().startActivity(intent);
            }
        }
        );
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
