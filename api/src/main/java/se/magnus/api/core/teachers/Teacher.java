package se.magnus.api.core.teachers;

public class Teacher{


    private final int id;
    private final String quality;
    private final String picture ;
    private final String name;
    private final String description;
    private final String serviceAddress;


    public  Teacher(){
        name ="";
        description = "";
        serviceAddress = null;
        id=0;
        quality = "";
        picture="";

    }

    public Teacher(int id, String quality, String picture, String name, String description, String serviceAddress) {
        this.id = id;
        this.quality = quality;
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.serviceAddress = serviceAddress;
    }

    public Integer getId() {
        return id;
    }

    public String getQuality() {
        return quality;
    }

    public String getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}