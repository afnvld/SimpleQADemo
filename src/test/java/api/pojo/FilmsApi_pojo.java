package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmsApi_pojo {
    private String id;
    private String title;
    private String description;
    private int release_date;

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRelease_date() {
        return release_date;
    }
}
