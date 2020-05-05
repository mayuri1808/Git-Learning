package package_navigationdrawer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewInfoApi {
    String BASE_URL="https://newsapi.org/v2/";
    @GET
    Call<Articles> getNewsInfo(@Url String url);
}
