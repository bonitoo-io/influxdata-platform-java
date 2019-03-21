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
 * RunLinks
 */
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-21T13:31:19.701+01:00[Europe/Prague]")
public class RunLinks {
  public static final String SERIALIZED_NAME_SELF = "self";
  @SerializedName(SERIALIZED_NAME_SELF)
  private String self = null;

  public static final String SERIALIZED_NAME_TASK = "task";
  @SerializedName(SERIALIZED_NAME_TASK)
  private String task = null;

  public static final String SERIALIZED_NAME_LOGS = "logs";
  @SerializedName(SERIALIZED_NAME_LOGS)
  private String logs = null;

  public static final String SERIALIZED_NAME_RETRY = "retry";
  @SerializedName(SERIALIZED_NAME_RETRY)
  private String retry = null;

  public RunLinks self(String self) {
    this.self = self;
    return this;
  }

   /**
   * Get self
   * @return self
  **/
  @ApiModelProperty(value = "")
  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public RunLinks task(String task) {
    this.task = task;
    return this;
  }

   /**
   * Get task
   * @return task
  **/
  @ApiModelProperty(value = "")
  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public RunLinks logs(String logs) {
    this.logs = logs;
    return this;
  }

   /**
   * Get logs
   * @return logs
  **/
  @ApiModelProperty(value = "")
  public String getLogs() {
    return logs;
  }

  public void setLogs(String logs) {
    this.logs = logs;
  }

  public RunLinks retry(String retry) {
    this.retry = retry;
    return this;
  }

   /**
   * Get retry
   * @return retry
  **/
  @ApiModelProperty(value = "")
  public String getRetry() {
    return retry;
  }

  public void setRetry(String retry) {
    this.retry = retry;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RunLinks runLinks = (RunLinks) o;
    return Objects.equals(this.self, runLinks.self) &&
        Objects.equals(this.task, runLinks.task) &&
        Objects.equals(this.logs, runLinks.logs) &&
        Objects.equals(this.retry, runLinks.retry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, task, logs, retry);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunLinks {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    task: ").append(toIndentedString(task)).append("\n");
    sb.append("    logs: ").append(toIndentedString(logs)).append("\n");
    sb.append("    retry: ").append(toIndentedString(retry)).append("\n");
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

