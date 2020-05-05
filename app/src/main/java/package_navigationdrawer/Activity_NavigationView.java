package package_navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.socialmediaintegration.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Activity_NavigationView extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    RecyclerView mRecyclerView;


    ActionBarDrawerToggle actionBarDrawerToggle;//This class is used for toggle the drawer.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity__navigation_view);
        setUpToolBar();
        navigationView=findViewById(R.id.navigation_view);
        mRecyclerView = navigationView.findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//To show list Vertical
        getNewsPaper();

    }
    private void getNewsPaper() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsApi newsApi;
        newsApi = retrofit.create(NewsApi.class);
        Call<NewsPaper> call1=newsApi.getNewsPaper("https://newsapi.org/v2/sources?apiKey=300e401e143940bc91c1d344186b36ea");
        // Call<List<NewsPaper>> call1 = newsApi.getNewsPaper();
        call1.enqueue(new Callback<NewsPaper>() {
            @Override
            public void onResponse(Call<NewsPaper> call, Response<NewsPaper> response) {

                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<NewsPaper.Sources> newsPaperArrayList = new ArrayList<>(response.body().getSources());
                    DataAdapter dataAdapter = new DataAdapter(newsPaperArrayList, Activity_NavigationView.this) {

                        @Override
                        void onNameClick(int position) {
                            calltoNewsAPI();
                        }
                    };
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(Activity_NavigationView.this));
                    mRecyclerView.setAdapter(dataAdapter);
                }

            }
            @Override
            public void onFailure(Call<NewsPaper> call, Throwable t) {

                Toast.makeText(Activity_NavigationView.this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void calltoNewsAPI() {
        Intent intent=new Intent(Activity_NavigationView.this,Activity_NewsInfo.class);
        startActivity(intent);


    }

    private void setUpToolBar(){
        drawerLayout=findViewById(R.id.drawerlayout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}
