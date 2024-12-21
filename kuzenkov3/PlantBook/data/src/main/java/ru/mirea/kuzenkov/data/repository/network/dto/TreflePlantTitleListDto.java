package ru.mirea.kuzenkov.data.repository.network.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TreflePlantTitleListDto {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class TreflePlantTitleDto {
        @SerializedName("slug") @Expose private String Title;
        public TreflePlantTitleDto() {}
        public TreflePlantTitleDto(String title) { Title = title; }
        public String getTitle() { return Title; }
    }

    @SerializedName("data") @Expose private List<TreflePlantTitleDto> TreflePlantTitles;

    public TreflePlantTitleListDto() {}
    public TreflePlantTitleListDto(List<TreflePlantTitleDto> treflePlantTitles) {
        TreflePlantTitles = treflePlantTitles;
    }
    public List<TreflePlantTitleDto> getTreflePlantTitles() {
        return TreflePlantTitles;
    }
}
