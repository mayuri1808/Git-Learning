package package_navigationdrawer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaintegration.R;

import java.util.ArrayList;

public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.ViewHolder> {
    ArrayList<Articles.Articles1> articles=new ArrayList<>();
    Context context;

    public NewsDataAdapter(ArrayList<Articles.Articles1> articles, Context context) {
        this.context=context;
        this.articles=articles;
    }

    @Override
    public NewsDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.newsitems, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsDataAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.author.setText(articles.get(i).getAuthor());
        viewHolder.title.setText(articles.get(i).getTitle());
        viewHolder.description.setText(articles.get(i).getDescription());
        viewHolder.url.setText(articles.get(i).getUrl());
        viewHolder.publishAt.setText(articles.get(i).getPublishedAt());
        viewHolder.content.setText(articles.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView author,title,description,url,publishAt,content;
        ViewHolder(View view) {
            super(view);

            author=(TextView)view.findViewById(R.id.author);
            title=(TextView)view.findViewById(R.id.title);
            description=(TextView)view.findViewById(R.id.description);
            url=(TextView)view.findViewById(R.id.url);
            publishAt=(TextView)view.findViewById(R.id.publishat);
            content=(TextView)view.findViewById(R.id.content);

        }
    }

}

