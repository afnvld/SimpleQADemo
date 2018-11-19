package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.testng.annotations.Ignore;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDetails {
    private String id;
    private String title;
    private String description;
    private int release_date;
    private int rt_score;
    private String director;
    private String producer;

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

    public int getRt_score() {
        return rt_score;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }
}
