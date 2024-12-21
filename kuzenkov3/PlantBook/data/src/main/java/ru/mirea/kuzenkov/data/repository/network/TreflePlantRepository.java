package ru.mirea.kuzenkov.data.repository.network;

import android.util.Log;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.kuzenkov.data.repository.network.dto.TreflePlantInfoListDto;
import ru.mirea.kuzenkov.data.repository.network.service.TreflePlantApi;
import ru.mirea.kuzenkov.domain.dto.PlantInfo;
import ru.mirea.kuzenkov.domain.repository.IPlantRepository;

public class TreflePlantRepository implements IPlantRepository {
    private TreflePlantApi treflePlantApi;
    private final String apiKey;

    public TreflePlantRepository(String apiKey) {
        treflePlantApi = new Retrofit.Builder()
            .baseUrl("https://trefle.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(TreflePlantApi.class);
        this.apiKey = apiKey;
    }

    @Override
    public PlantInfo GetPlantInfo(String title) {
        try {
            var result = treflePlantApi.getPlantInfo(title, apiKey).execute();
            if(result.code() != 200) {
                return null;
            } else {
                return TrefleDtoToDomainDto(result.body().getTreflePlantInfo());
            }
        } catch (IOException e) {
            return null;
        }
    }
    @Override
    public Set<String> GetPlantList() {
        try {
            var result = treflePlantApi.getPlantTitles(1, apiKey).execute();
            if(result.code() != 200) {
                return Collections.emptySet();
            } else {
                return result.body().getTreflePlantTitles().stream().
                        map(treflePlantInfoDto -> treflePlantInfoDto.getTitle()).
                        collect(Collectors.toSet());
            }
        } catch (IOException e) {
            return Collections.emptySet();
        }
    }

    private static PlantInfo TrefleDtoToDomainDto(TreflePlantInfoListDto.TreflePlantInfoDto info) {



        var plantInfoTitle = info.getCommonName();
        if(plantInfoTitle == null) {
            plantInfoTitle = info.getScientifiName();
        }
        if(plantInfoTitle == null) {
            plantInfoTitle = "undefined...";
        }

        return new PlantInfo(
                plantInfoTitle,
                info.getImageUrl(),
                String.format("Scientific name: %s\nAuthor: %s\nYear: %d\n", info.getScientifiName(), info.getAuthor(), info.getYear())
        );
    }
}
