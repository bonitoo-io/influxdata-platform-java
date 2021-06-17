/*
 * Influx OSS API Service
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.influxdb.client.domain;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.influxdb.client.domain.BuilderConfigAggregateWindow;
import com.influxdb.client.domain.BuilderFunctionsType;
import com.influxdb.client.domain.BuilderTagsType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * BuilderConfig
 */

public class BuilderConfig {
  public static final String SERIALIZED_NAME_BUCKETS = "buckets";
  @SerializedName(SERIALIZED_NAME_BUCKETS)
  private List<String> buckets = new ArrayList<>();

  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private List<BuilderTagsType> tags = new ArrayList<>();

  public static final String SERIALIZED_NAME_FUNCTIONS = "functions";
  @SerializedName(SERIALIZED_NAME_FUNCTIONS)
  private List<BuilderFunctionsType> functions = new ArrayList<>();

  public static final String SERIALIZED_NAME_AGGREGATE_WINDOW = "aggregateWindow";
  @SerializedName(SERIALIZED_NAME_AGGREGATE_WINDOW)
  private BuilderConfigAggregateWindow aggregateWindow = null;

  public BuilderConfig buckets(List<String> buckets) {
    this.buckets = buckets;
    return this;
  }

  public BuilderConfig addBucketsItem(String bucketsItem) {
    if (this.buckets == null) {
      this.buckets = new ArrayList<>();
    }
    this.buckets.add(bucketsItem);
    return this;
  }

   /**
   * Get buckets
   * @return buckets
  **/
  @ApiModelProperty(value = "")
  public List<String> getBuckets() {
    return buckets;
  }

  public void setBuckets(List<String> buckets) {
    this.buckets = buckets;
  }

  public BuilderConfig tags(List<BuilderTagsType> tags) {
    this.tags = tags;
    return this;
  }

  public BuilderConfig addTagsItem(BuilderTagsType tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(value = "")
  public List<BuilderTagsType> getTags() {
    return tags;
  }

  public void setTags(List<BuilderTagsType> tags) {
    this.tags = tags;
  }

  public BuilderConfig functions(List<BuilderFunctionsType> functions) {
    this.functions = functions;
    return this;
  }

  public BuilderConfig addFunctionsItem(BuilderFunctionsType functionsItem) {
    if (this.functions == null) {
      this.functions = new ArrayList<>();
    }
    this.functions.add(functionsItem);
    return this;
  }

   /**
   * Get functions
   * @return functions
  **/
  @ApiModelProperty(value = "")
  public List<BuilderFunctionsType> getFunctions() {
    return functions;
  }

  public void setFunctions(List<BuilderFunctionsType> functions) {
    this.functions = functions;
  }

  public BuilderConfig aggregateWindow(BuilderConfigAggregateWindow aggregateWindow) {
    this.aggregateWindow = aggregateWindow;
    return this;
  }

   /**
   * Get aggregateWindow
   * @return aggregateWindow
  **/
  @ApiModelProperty(value = "")
  public BuilderConfigAggregateWindow getAggregateWindow() {
    return aggregateWindow;
  }

  public void setAggregateWindow(BuilderConfigAggregateWindow aggregateWindow) {
    this.aggregateWindow = aggregateWindow;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuilderConfig builderConfig = (BuilderConfig) o;
    return Objects.equals(this.buckets, builderConfig.buckets) &&
        Objects.equals(this.tags, builderConfig.tags) &&
        Objects.equals(this.functions, builderConfig.functions) &&
        Objects.equals(this.aggregateWindow, builderConfig.aggregateWindow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buckets, tags, functions, aggregateWindow);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuilderConfig {\n");
    sb.append("    buckets: ").append(toIndentedString(buckets)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    functions: ").append(toIndentedString(functions)).append("\n");
    sb.append("    aggregateWindow: ").append(toIndentedString(aggregateWindow)).append("\n");
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

