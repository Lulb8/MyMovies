package android.lucie.mymovies;

import android.content.Context;
import android.content.Intent;
import android.lucie.mymovies.model.Movie;
import java.util.List;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CelluleJava> {
    private List<Movie> listValues;

    private static final String NAME = "showTextView";


    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public View layout;

        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.title);
        }
    }

    public void remove(int position) {
        listValues.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MovieAdapter(List<Movie> listValues) {
        this.listValues = listValues;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_movie, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Movie currentMovie = listValues.get(position);

        final String name = currentMovie.getName();   //TODO faire pour les autres
        holder.txtHeader.setText(name);

        //TODO afficher le detail
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(position);
            }
        });

        /*
        final String gender = currentMovie.getGender();
        holder.txtFooter.setText(gender);*/ //TODO mettre la description
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listValues.size();
    }
}
