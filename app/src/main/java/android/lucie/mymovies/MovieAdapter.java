package android.lucie.mymovies;

import android.content.Context;
import android.lucie.mymovies.model.Movie;
import java.util.List;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CelluleJava> {

    private List<Movie> listValues;
    private final OnItemClickListener listener;
    private Context context;


    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    //private static final String NAME = "showTextView";


    public class CelluleJava extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        //public View layout;

        public CelluleJava(View view) {
            super(view);
            //layout = view;
            txtHeader = (TextView) view.findViewById(R.id.title);
        }
    }

    public void remove(int position) {
        listValues.remove(position);
        notifyItemRemoved(position);
    }

    public MovieAdapter(List<Movie> listValues, OnItemClickListener listener, Context context) {
        this.listValues = listValues;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_movie, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        final Movie movie = listValues.get(position);
        final String name = listValues.get(position).getName();

        holder.txtHeader.setText(name);

        //TODO afficher le detail
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //remove(position);
                listener.onItemClick(movie);
            }
        });
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listValues.size();
    }
}
