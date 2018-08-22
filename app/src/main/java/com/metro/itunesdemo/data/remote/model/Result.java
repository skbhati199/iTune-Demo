
package com.metro.itunesdemo.data.remote.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "result")
public class Result {

    @Expose
    @PrimaryKey
    public Long id;

    @SerializedName("wrapperType")
    @Expose
    @ColumnInfo(name = "wrapperType")
    private String wrapperType;
    @SerializedName("kind")
    @Expose
    @ColumnInfo(name = "kind")
    private String kind;
    @SerializedName("trackId")
    @ColumnInfo(name = "trackId")
    @Expose
    private Integer trackId;
    @SerializedName("artistName")
    @ColumnInfo(name = "artistName")
    @Expose
    private String artistName;
    @SerializedName("trackName")
    @ColumnInfo(name = "trackName")
    @Expose
    private String trackName;
    @SerializedName("trackCensoredName")
    @ColumnInfo(name = "trackCensoredName")
    @Expose
    private String trackCensoredName;
    @SerializedName("trackViewUrl")
    @ColumnInfo(name = "trackViewUrl")
    @Expose
    private String trackViewUrl;
    @SerializedName("previewUrl")
    @ColumnInfo(name = "previewUrl")
    @Expose
    private String previewUrl;
    @SerializedName("artworkUrl30")
    @ColumnInfo(name = "artworkUrl30")
    @Expose
    private String artworkUrl30;
    @SerializedName("artworkUrl60")
    @ColumnInfo(name = "artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    @ColumnInfo(name = "artworkUrl100")
    @Expose
    private String artworkUrl100;
    @SerializedName("collectionPrice")
    @ColumnInfo(name = "collectionPrice")
    @Expose
    private Double collectionPrice;
    @SerializedName("trackPrice")
    @ColumnInfo(name = "trackPrice")
    @Expose
    private Double trackPrice;
    @SerializedName("trackRentalPrice")
    @ColumnInfo(name = "trackRentalPrice")
    @Expose
    private Double trackRentalPrice;
    @SerializedName("collectionHdPrice")
    @ColumnInfo(name = "collectionHdPrice")
    @Expose
    private Double collectionHdPrice;
    @SerializedName("trackHdPrice")
    @ColumnInfo(name = "trackHdPrice")
    @Expose
    private Double trackHdPrice;
    @SerializedName("trackHdRentalPrice")
    @ColumnInfo(name = "trackHdRentalPrice")
    @Expose
    private Double trackHdRentalPrice;
    @SerializedName("releaseDate")
    @ColumnInfo(name = "releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("collectionExplicitness")
    @ColumnInfo(name = "collectionExplicitness")
    @Expose
    private String collectionExplicitness;
    @SerializedName("trackExplicitness")
    @ColumnInfo(name = "trackExplicitness")
    @Expose
    private String trackExplicitness;
    @SerializedName("trackTimeMillis")
    @ColumnInfo(name = "trackTimeMillis")
    @Expose
    private Integer trackTimeMillis;
    @SerializedName("country")
    @ColumnInfo(name = "country")
    @Expose
    private String country;
    @SerializedName("currency")
    @ColumnInfo(name = "currency")
    @Expose
    private String currency;
    @SerializedName("primaryGenreName")
    @ColumnInfo(name = "primaryGenreName")
    @Expose
    private String primaryGenreName;
    @SerializedName("contentAdvisoryRating")
    @ColumnInfo(name = "contentAdvisoryRating")
    @Expose
    private String contentAdvisoryRating;
    @SerializedName("hasITunesExtras")
    @ColumnInfo(name = "hasITunesExtras")
    @Expose
    private Boolean hasITunesExtras;
    @SerializedName("artistId")
    @ColumnInfo(name = "artistId")
    @Expose
    private Integer artistId;
    @SerializedName("collectionId")
    @ColumnInfo(name = "collectionId")
    @Expose
    private Integer collectionId;
    @SerializedName("collectionName")
    @ColumnInfo(name = "collectionName")
    @Expose
    private String collectionName;
    @SerializedName("collectionCensoredName")
    @ColumnInfo(name = "collectionCensoredName")
    @Expose
    private String collectionCensoredName;
    @SerializedName("artistViewUrl")
    @ColumnInfo(name = "artistViewUrl")
    @Expose
    private String artistViewUrl;
    @SerializedName("collectionViewUrl")
    @ColumnInfo(name = "collectionViewUrl")
    @Expose
    private String collectionViewUrl;
    @SerializedName("discCount")
    @ColumnInfo(name = "discCount")
    @Expose
    private Integer discCount;
    @SerializedName("discNumber")
    @ColumnInfo(name = "discNumber")
    @Expose
    private Integer discNumber;
    @SerializedName("trackCount")
    @ColumnInfo(name = "trackCount")
    @Expose
    private Integer trackCount;
    @SerializedName("trackNumber")
    @ColumnInfo(name = "trackNumber")
    @Expose
    private Integer trackNumber;
    @SerializedName("isStreamable")
    @ColumnInfo(name = "isStreamable")
    @Expose
    private Boolean isStreamable;

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public Double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(Double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public Double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public Double getTrackRentalPrice() {
        return trackRentalPrice;
    }

    public void setTrackRentalPrice(Double trackRentalPrice) {
        this.trackRentalPrice = trackRentalPrice;
    }

    public Double getCollectionHdPrice() {
        return collectionHdPrice;
    }

    public void setCollectionHdPrice(Double collectionHdPrice) {
        this.collectionHdPrice = collectionHdPrice;
    }

    public Double getTrackHdPrice() {
        return trackHdPrice;
    }

    public void setTrackHdPrice(Double trackHdPrice) {
        this.trackHdPrice = trackHdPrice;
    }

    public Double getTrackHdRentalPrice() {
        return trackHdRentalPrice;
    }

    public void setTrackHdRentalPrice(Double trackHdRentalPrice) {
        this.trackHdRentalPrice = trackHdRentalPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public Boolean getHasITunesExtras() {
        return hasITunesExtras;
    }

    public void setHasITunesExtras(Boolean hasITunesExtras) {
        this.hasITunesExtras = hasITunesExtras;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public Integer getDiscCount() {
        return discCount;
    }

    public void setDiscCount(Integer discCount) {
        this.discCount = discCount;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Boolean getIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

}
