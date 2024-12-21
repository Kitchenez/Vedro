package ru.mirea.kuzenkov.data.repository.network.dto;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TreflePlantInfoListDto {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class TreflePlantInfoDto {
        @SerializedName("common_name") @Expose private String CommonName;
        @SerializedName("scientific_name") @Expose private String ScientifiName;
        @SerializedName("author") @Expose private String Author;
        @SerializedName("year") @Expose private Integer Year;
        @SerializedName("synonyms") @Expose private List<String> Synonyms;
        @SerializedName("image_url") @Expose private String ImageUrl;

        public TreflePlantInfoDto(String commonName, String scientifiName, String author, Integer year, List<String> synonyms, String imageUrl) {
            CommonName = commonName;
            ScientifiName = scientifiName;
            Author = author;
            Year = year;
            Synonyms = synonyms;
            ImageUrl = imageUrl;
        }
        public String getCommonName() {
            return CommonName;
        }
        public String getScientifiName() {
            return ScientifiName;
        }
        public String getAuthor() {
            return Author;
        }
        public Integer getYear() {
            return Year;
        }
        public List<String> getSynonyms() {
            return Synonyms;
        }
        public String getImageUrl() {
            return ImageUrl;
        }

        @NonNull
        @Override
        public String toString() {
            return String.format("[TreflePlantInfoDto][%s/%s/%s/%d/%s]", CommonName, ScientifiName, Author, Year, ImageUrl);
        }
    }

    @SerializedName("data") @Expose private TreflePlantInfoDto TreflePlantInfo;
    public TreflePlantInfoListDto() {}
    public TreflePlantInfoListDto(TreflePlantInfoDto treflePlantInfo) { TreflePlantInfo = treflePlantInfo; }
    public TreflePlantInfoDto getTreflePlantInfo() {
        return TreflePlantInfo;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("[TreflePlantInfoListDto][%s]", TreflePlantInfo.toString());
    }
}
