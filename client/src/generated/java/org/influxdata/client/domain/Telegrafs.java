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
import java.util.ArrayList;
import java.util.List;
import org.influxdata.client.domain.Telegraf;

/**
 * Telegrafs
 */
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-19T14:55:47.021+01:00[Europe/Prague]")
public class Telegrafs {
  public static final String SERIALIZED_NAME_CONFIGURATIONS = "configurations";
  @SerializedName(SERIALIZED_NAME_CONFIGURATIONS)
  private List<Telegraf> configurations = new ArrayList<>();

  public Telegrafs configurations(List<Telegraf> configurations) {
    this.configurations = configurations;
    return this;
  }

  public Telegrafs addConfigurationsItem(Telegraf configurationsItem) {
    if (this.configurations == null) {
      this.configurations = new ArrayList<>();
    }
    this.configurations.add(configurationsItem);
    return this;
  }

   /**
   * Get configurations
   * @return configurations
  **/
  @ApiModelProperty(value = "")
  public List<Telegraf> getConfigurations() {
    return configurations;
  }

  public void setConfigurations(List<Telegraf> configurations) {
    this.configurations = configurations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Telegrafs telegrafs = (Telegrafs) o;
    return Objects.equals(this.configurations, telegrafs.configurations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configurations);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Telegrafs {\n");
    sb.append("    configurations: ").append(toIndentedString(configurations)).append("\n");
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

