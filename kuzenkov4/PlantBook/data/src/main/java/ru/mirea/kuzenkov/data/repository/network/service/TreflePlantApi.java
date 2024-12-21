package ru.mirea.kuzenkov.data.repository.network.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.mirea.kuzenkov.data.repository.network.dto.TreflePlantInfoListDto;
import ru.mirea.kuzenkov.data.repository.network.dto.TreflePlantTitleListDto;

public interface TreflePlantApi {
    @GET("api/v1/plants")
    Call<TreflePlantTitleListDto> getPlantTitles(@Query("page") int page, @Query("token") String apiKey);

    @GET("api/v1/plants/{plant_id}")
    Call<TreflePlantInfoListDto> getPlantInfo(@Path("plant_id") String plant_id, @Query("token") String apiKey);
}
