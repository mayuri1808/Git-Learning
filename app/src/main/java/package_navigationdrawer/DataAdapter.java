package package_navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.socialmediaintegration.R;

import java.util.ArrayList;

public abstract class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    ArrayList<NewsPaper.Sources> articles=new ArrayList<>();
    Context context;

    public DataAdapter(ArrayList<NewsPaper.Sources> articles, Context context) {
        this.context=context;
        this.articles=articles;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.namee.setText(articles.get(i).getName());
        viewHolder.namee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNameClick(i);
            }
        });
    }

    abstract void onNameClick(int position);


    @Override
    public int getItemCount() {

        return articles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView namee;


        ViewHolder(View view) {
            super(view);

            namee=(TextView)view.findViewById(R.id.Name);
        }
    }

}
