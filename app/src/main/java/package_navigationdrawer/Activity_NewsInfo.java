package package_navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.socialmediaintegration.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_NewsInfo extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__news_info);
        recyclerView =findViewById(R.id.rv_newinfo);
        getNewsInfo();
    }

    private void getNewsInfo() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewInfoApi newsInfoApi;
        newsInfoApi = retrofit.create(NewInfoApi.class);
        Call<Articles> call2=newsInfoApi.getNewsInfo("https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=300e401e143940bc91c1d344186b36ea");
        call2.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {

                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Articles.Articles1> newsPaperArrayList = new ArrayList<>(response.body().getArticles());
                    NewsDataAdapter newsDataAdapter = new NewsDataAdapter(newsPaperArrayList, Activity_NewsInfo.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Activity_NewsInfo.this));
                    recyclerView.setAdapter(newsDataAdapter);
                }

            }
            @Override
            public void onFailure(Call<Articles> call, Throwable t) {

                Toast.makeText(Activity_NewsInfo.this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
            }

        });
    }


}
