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

/**
 * TaskCreateRequest
 */
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-19T14:55:47.021+01:00[Europe/Prague]")
public class TaskCreateRequest {
  public static final String SERIALIZED_NAME_ORG_I_D = "orgID";
  @SerializedName(SERIALIZED_NAME_ORG_I_D)
  private String orgID = null;

  public static final String SERIALIZED_NAME_ORG = "org";
  @SerializedName(SERIALIZED_NAME_ORG)
  private String org = null;

  /**
   * Starting state of the task. &#39;inactive&#39; tasks are not run until they are updated to &#39;active&#39;
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive");

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
  private StatusEnum status = StatusEnum.ACTIVE;

  public static final String SERIALIZED_NAME_FLUX = "flux";
  @SerializedName(SERIALIZED_NAME_FLUX)
  private String flux = null;

  public static final String SERIALIZED_NAME_TOKEN = "token";
  @SerializedName(SERIALIZED_NAME_TOKEN)
  private String token = null;

  public TaskCreateRequest orgID(String orgID) {
    this.orgID = orgID;
    return this;
  }

   /**
   * The ID of the organization that owns this Task.
   * @return orgID
  **/
  @ApiModelProperty(value = "The ID of the organization that owns this Task.")
  public String getOrgID() {
    return orgID;
  }

  public void setOrgID(String orgID) {
    this.orgID = orgID;
  }

  public TaskCreateRequest org(String org) {
    this.org = org;
    return this;
  }

   /**
   * The name of the organization that owns this Task.
   * @return org
  **/
  @ApiModelProperty(value = "The name of the organization that owns this Task.")
  public String getOrg() {
    return org;
  }

  public void setOrg(String org) {
    this.org = org;
  }

  public TaskCreateRequest status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Starting state of the task. &#39;inactive&#39; tasks are not run until they are updated to &#39;active&#39;
   * @return status
  **/
  @ApiModelProperty(value = "Starting state of the task. 'inactive' tasks are not run until they are updated to 'active'")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TaskCreateRequest flux(String flux) {
    this.flux = flux;
    return this;
  }

   /**
   * The Flux script to run for this task.
   * @return flux
  **/
  @ApiModelProperty(required = true, value = "The Flux script to run for this task.")
  public String getFlux() {
    return flux;
  }

  public void setFlux(String flux) {
    this.flux = flux;
  }

  public TaskCreateRequest token(String token) {
    this.token = token;
    return this;
  }

   /**
   * The token to use for authenticating this task when it executes queries. If omitted, uses the token associated with the request that creates the task.
   * @return token
  **/
  @ApiModelProperty(value = "The token to use for authenticating this task when it executes queries. If omitted, uses the token associated with the request that creates the task.")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskCreateRequest taskCreateRequest = (TaskCreateRequest) o;
    return Objects.equals(this.orgID, taskCreateRequest.orgID) &&
        Objects.equals(this.org, taskCreateRequest.org) &&
        Objects.equals(this.status, taskCreateRequest.status) &&
        Objects.equals(this.flux, taskCreateRequest.flux) &&
        Objects.equals(this.token, taskCreateRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orgID, org, status, flux, token);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskCreateRequest {\n");
    sb.append("    orgID: ").append(toIndentedString(orgID)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    flux: ").append(toIndentedString(flux)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

