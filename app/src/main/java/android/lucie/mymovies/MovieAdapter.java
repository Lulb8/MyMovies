package android.lucie.mymovies;

import android.lucie.mymovies.model.Movie;
import android.lucie.mymovies.model.Movie;

import java.util.List;

import android.lucie.mymovies.model.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CelluleJava> {
    private List<Movie> listValues;

    public class CelluleJava extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = txtHeader.get(mPosition);
            // Change the word in the mWordList.
            txtHeader.set(mPosition, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            txtHeader.notifyDataSetChanged();
        }
    }

    public void add(int position, Movie item) {
        listValues.add(position, item);
        notifyItemInserted(position);
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
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(position);
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
