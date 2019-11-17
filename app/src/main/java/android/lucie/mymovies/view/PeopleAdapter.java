package android.lucie.mymovies.view;

import android.content.Context;
import android.lucie.mymovies.R;
import android.lucie.mymovies.model.People;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.CelluleJava> {

    private List<People> listValues;
    private final OnItemClickListener listener;
    private Context context;


    public interface OnItemClickListener {
        void onItemClick(People people);
    }


    public class CelluleJava extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView imgIcon;

        public CelluleJava(View view) {
            super(view);
            txtHeader = (TextView) view.findViewById(R.id.title);
            txtFooter = (TextView) view.findViewById(R.id.gender);
            imgIcon = (ImageView) view.findViewById(R.id.imageIcon);
        }
    }

    public PeopleAdapter(List<People> listValues, OnItemClickListener listener, Context context) {
        this.listValues = listValues;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_people, parent, false);
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        final People people = listValues.get(position);
        final String name = listValues.get(position).getName();
        final String gender = listValues.get(position).getGender();
        final String image_icon = listValues.get(position).getImageIcon();
        System.out.println("url = " + image_icon);

        holder.txtHeader.setText(name);
        holder.txtFooter.setText("Gender : " + gender);

        /*
        Picasso.with(context)
                .load(image_icon)
                .error(R.drawable.error_icon)
                .into(holder.imgIcon);
        */

        Glide.with(context)
                .load(image_icon)
                .error(R.drawable.error_icon)
                .fitCenter()
                .into(holder.imgIcon);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(people);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listValues.size();
    }
}