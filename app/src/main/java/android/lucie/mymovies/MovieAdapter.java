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
        public TextView txtFooter;

        public CelluleJava(View view) {
            super(view);
            txtHeader = (TextView) view.findViewById(R.id.title);
            txtFooter = (TextView) view.findViewById(R.id.gender);
        }
    }

    public MovieAdapter(List<Movie> listValues, OnItemClickListener listener, Context context) {
        this.listValues = listValues;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_movie, parent, false);
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        final Movie movie = listValues.get(position);
        final String name = listValues.get(position).getName();
        final String gender = listValues.get(position).getGender();

        holder.txtHeader.setText(name);
        holder.txtFooter.setText(gender);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listValues.size();
    }
}
