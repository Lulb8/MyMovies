package android.lucie.mymovies;

import android.lucie.mymovies.model.Movie;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CelluleJava> {
    private List<Movie> listValues;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.title);
            txtFooter = (TextView) v.findViewById(R.id.synopsis);
            image = v.findViewById(R.id.poster);
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
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);   //TODO afficher le detail
            }
        });

        //holder.image.setImage...  //TODO mettre l'image
        final String synopsis = currentMovie.getSynopsis();
        holder.txtFooter.setText(synopsis); //TODO mettre la desciption
    }

    @Override
    public int getItemCount() {
        return listValues.size();
    }

}
