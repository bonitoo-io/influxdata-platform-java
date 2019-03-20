/*
 * Influx API Service
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.influxdata.client.domain;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import org.influxdata.client.domain.RunLinks;

/**
 * Run
 */
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-19T14:55:47.021+01:00[Europe/Prague]")
public class Run {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id = null;

  public static final String SERIALIZED_NAME_TASK_I_D = "taskID";
  @SerializedName(SERIALIZED_NAME_TASK_I_D)
  private String taskID = null;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    SCHEDULED("scheduled"),
    
    STARTED("started"),
    
    FAILED("failed"),
    
    SUCCESS("success"),
    
    CANCELED("canceled");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status = null;

  public static final String SERIALIZED_NAME_SCHEDULED_FOR = "scheduledFor";
  @SerializedName(SERIALIZED_NAME_SCHEDULED_FOR)
  private OffsetDateTime scheduledFor = null;

  public static final String SERIALIZED_NAME_STARTED_AT = "startedAt";
  @SerializedName(SERIALIZED_NAME_STARTED_AT)
  private OffsetDateTime startedAt = null;

  public static final String SERIALIZED_NAME_FINISHED_AT = "finishedAt";
  @SerializedName(SERIALIZED_NAME_FINISHED_AT)
  private OffsetDateTime finishedAt = null;

  public static final String SERIALIZED_NAME_REQUESTED_AT = "requestedAt";
  @SerializedName(SERIALIZED_NAME_REQUESTED_AT)
  private OffsetDateTime requestedAt = null;

  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private RunLinks links = null;

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

   /**
   * Get taskID
   * @return taskID
  **/
  @ApiModelProperty(value = "")
  public String getTaskID() {
    return taskID;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public Run scheduledFor(OffsetDateTime scheduledFor) {
    this.scheduledFor = scheduledFor;
    return this;
  }

   /**
   * Time used for run&#39;s \&quot;now\&quot; option, RFC3339.
   * @return scheduledFor
  **/
  @ApiModelProperty(value = "Time used for run's \"now\" option, RFC3339.")
  public OffsetDateTime getScheduledFor() {
    return scheduledFor;
  }

  public void setScheduledFor(OffsetDateTime scheduledFor) {
    this.scheduledFor = scheduledFor;
  }

   /**
   * Time run started executing, RFC3339Nano.
   * @return startedAt
  **/
  @ApiModelProperty(value = "Time run started executing, RFC3339Nano.")
  public OffsetDateTime getStartedAt() {
    return startedAt;
  }

   /**
   * Time run finished executing, RFC3339Nano.
   * @return finishedAt
  **/
  @ApiModelProperty(value = "Time run finished executing, RFC3339Nano.")
  public OffsetDateTime getFinishedAt() {
    return finishedAt;
  }

   /**
   * Time run was manually requested, RFC3339Nano.
   * @return requestedAt
  **/
  @ApiModelProperty(value = "Time run was manually requested, RFC3339Nano.")
  public OffsetDateTime getRequestedAt() {
    return requestedAt;
  }

  public Run links(RunLinks links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public RunLinks getLinks() {
    return links;
  }

  public void setLinks(RunLinks links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Run run = (Run) o;
    return Objects.equals(this.id, run.id) &&
        Objects.equals(this.taskID, run.taskID) &&
        Objects.equals(this.status, run.status) &&
        Objects.equals(this.scheduledFor, run.scheduledFor) &&
        Objects.equals(this.startedAt, run.startedAt) &&
        Objects.equals(this.finishedAt, run.finishedAt) &&
        Objects.equals(this.requestedAt, run.requestedAt) &&
        Objects.equals(this.links, run.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, taskID, status, scheduledFor, startedAt, finishedAt, requestedAt, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Run {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    taskID: ").append(toIndentedString(taskID)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    scheduledFor: ").append(toIndentedString(scheduledFor)).append("\n");
    sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
    sb.append("    finishedAt: ").append(toIndentedString(finishedAt)).append("\n");
    sb.append("    requestedAt: ").append(toIndentedString(requestedAt)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
