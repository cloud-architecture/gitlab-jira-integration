package fr.mmarie.api.gitlab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = "type")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    public enum Type {
        PUSH,
        TAG_PUSH,
        ISSUE,
        NOTE,
        MERGE_REQUEST
    }

    @JsonProperty("object_kind")
    @NotNull
    private Type type;

    @JsonProperty("before")
    private String before;

    @JsonProperty("after")
    private String after;

    @JsonProperty("ref")
    private String ref;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("project_id")
    private Long projectId;

    @JsonProperty("repository")
    private Repository repository;

    @JsonProperty("commits")
    private List<Commit> commits;

    @JsonProperty("object_attributes")
    private Map<String, Object> objectAttributes;

    @JsonProperty("total_commits_count")
    private Long totalCommitsCount;

    @VisibleForTesting
    public Event(Type type) {
        this.type = type;
    }
}
