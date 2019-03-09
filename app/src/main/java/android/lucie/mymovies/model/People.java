package android.lucie.mymovies.model;

public class People {
    private String name;
    private String gender;
    private String homeworld;
    private String birth_year;
    private String hair_color;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getHairColor() {
        return hair_color;
    }

    public void setHairColor(String hair_color) {
        this.hair_color = hair_color;
    }
}
