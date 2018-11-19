package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDetailsAPI {
    private String tracked_until;
    private String competitive_rank;
    private String solo_competitive_rank;
    private int rank_tier;
    private int account_id;

    @JsonProperty("profile")
    public void unpoackProfile(Map<String, Object> profile) {
        this.account_id = (int) profile.get("account_id");
        this.personaname= (String) profile.get("personaname");
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getPersonaname() {
        return personaname;
    }

    private String personaname;

    public String getTracked_until() {
        return tracked_until;
    }

    public String getCompetitive_rank() {
        return competitive_rank;
    }

    public String getSolo_competitive_rank() {
        return solo_competitive_rank;
    }

    public int getRank_tier() {
        return rank_tier;
    }
}
