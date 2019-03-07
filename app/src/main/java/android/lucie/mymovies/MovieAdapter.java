package android.lucie.mymovies;

import android.content.Context;
import android.content.Intent;
import android.lucie.mymovies.model.Movie;
import java.util.List;

import android.os.Parcelable;
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
    private Context mContext;

    private static final String NAME = "showTextView";
    private static final String TAG = "RecyclerViewAdapter";



    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public View layout;

        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.title);
        }
    }

    public MovieAdapter(List<Movie> listValues, Context context) {
        this.listValues = listValues;
        this.mContext = context;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_movie, parent, false);
        CelluleJava vh = new CelluleJava(v);    // set the view's size, margins, paddings and layout parameters
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
                Log.d(TAG, "onClick: clicked on: " + listValues.get(position));

                Toast.makeText(mContext, (CharSequence) listValues.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, Main2Activity.class);
                intent.putExtra(TAG, (Parcelable) listValues.get(position));
                mContext.startActivity(intent);



                /*Log.d(NAME, "onClick: clicked on: " + listValues.get(position));

                Intent intent = new Intent(mContext, Main2Activity.class);
                TextView showTextView = (TextView) findViewById(R.id.name);
                String str = showTextView.getText().toString();
                intent.putExtra(NAME, str);
                startActivity(intent);*/
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
