package se.magnus.api.core.recommended;

public class Recommend {

    private int teacherId;
    private String  percent;
    private String region;
    private int rating;
    private String serviceAddress;

    public Recommend() {
        teacherId = 0;
        rating= 0;
        percent = "";
        region = "";
        serviceAddress = "";
    }

    public Recommend(int teacherId,int rating,String percent, String region, String serviceAddress) {
        this.teacherId = teacherId;
        this.percent = percent;
        this.rating = rating;
        this.region = region;
        this.serviceAddress = serviceAddress;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
