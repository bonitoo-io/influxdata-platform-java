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


package com.influxdb.client.domain;

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

/**
 * A description of a particular axis for a visualization
 */
@ApiModel(description = "A description of a particular axis for a visualization")

public class Axis {
  public static final String SERIALIZED_NAME_BOUNDS = "bounds";
  @SerializedName(SERIALIZED_NAME_BOUNDS)
  private List<Long> bounds = new ArrayList<>();

  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_PREFIX = "prefix";
  @SerializedName(SERIALIZED_NAME_PREFIX)
  private String prefix;

  public static final String SERIALIZED_NAME_SUFFIX = "suffix";
  @SerializedName(SERIALIZED_NAME_SUFFIX)
  private String suffix;

  public static final String SERIALIZED_NAME_BASE = "base";
  @SerializedName(SERIALIZED_NAME_BASE)
  private String base;

  public static final String SERIALIZED_NAME_SCALE = "scale";
  @SerializedName(SERIALIZED_NAME_SCALE)
  private String scale;

  public Axis bounds(List<Long> bounds) {
    this.bounds = bounds;
    return this;
  }

  public Axis addBoundsItem(Long boundsItem) {
    if (this.bounds == null) {
      this.bounds = new ArrayList<>();
    }
    this.bounds.add(boundsItem);
    return this;
  }

   /**
   * The extents of an axis in the form [lower, upper]. Clients determine whether bounds are to be inclusive or exclusive of their limits
   * @return bounds
  **/
  @ApiModelProperty(value = "The extents of an axis in the form [lower, upper]. Clients determine whether bounds are to be inclusive or exclusive of their limits")
  public List<Long> getBounds() {
    return bounds;
  }

  public void setBounds(List<Long> bounds) {
    this.bounds = bounds;
  }

  public Axis label(String label) {
    this.label = label;
    return this;
  }

   /**
   * label is a description of this Axis
   * @return label
  **/
  @ApiModelProperty(value = "label is a description of this Axis")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Axis prefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

   /**
   * Prefix represents a label prefix for formatting axis values.
   * @return prefix
  **/
  @ApiModelProperty(value = "Prefix represents a label prefix for formatting axis values.")
  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public Axis suffix(String suffix) {
    this.suffix = suffix;
    return this;
  }

   /**
   * Suffix represents a label suffix for formatting axis values.
   * @return suffix
  **/
  @ApiModelProperty(value = "Suffix represents a label suffix for formatting axis values.")
  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public Axis base(String base) {
    this.base = base;
    return this;
  }

   /**
   * Base represents the radix for formatting axis values.
   * @return base
  **/
  @ApiModelProperty(value = "Base represents the radix for formatting axis values.")
  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public Axis scale(String scale) {
    this.scale = scale;
    return this;
  }

   /**
   * Scale is the axis formatting scale. Supported: \&quot;log\&quot;, \&quot;linear\&quot;
   * @return scale
  **/
  @ApiModelProperty(value = "Scale is the axis formatting scale. Supported: \"log\", \"linear\"")
  public String getScale() {
    return scale;
  }

  public void setScale(String scale) {
    this.scale = scale;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Axis axis = (Axis) o;
    return Objects.equals(this.bounds, axis.bounds) &&
        Objects.equals(this.label, axis.label) &&
        Objects.equals(this.prefix, axis.prefix) &&
        Objects.equals(this.suffix, axis.suffix) &&
        Objects.equals(this.base, axis.base) &&
        Objects.equals(this.scale, axis.scale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bounds, label, prefix, suffix, base, scale);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Axis {\n");
    sb.append("    bounds: ").append(toIndentedString(bounds)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
    sb.append("    base: ").append(toIndentedString(base)).append("\n");
    sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
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
