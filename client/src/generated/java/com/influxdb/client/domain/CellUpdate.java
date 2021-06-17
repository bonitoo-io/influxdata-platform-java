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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CellUpdate
 */

public class CellUpdate {
  public static final String SERIALIZED_NAME_X = "x";
  @SerializedName(SERIALIZED_NAME_X)
  private Integer x;

  public static final String SERIALIZED_NAME_Y = "y";
  @SerializedName(SERIALIZED_NAME_Y)
  private Integer y;

  public static final String SERIALIZED_NAME_W = "w";
  @SerializedName(SERIALIZED_NAME_W)
  private Integer w;

  public static final String SERIALIZED_NAME_H = "h";
  @SerializedName(SERIALIZED_NAME_H)
  private Integer h;

  public CellUpdate x(Integer x) {
    this.x = x;
    return this;
  }

   /**
   * Get x
   * @return x
  **/
  @ApiModelProperty(value = "")
  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public CellUpdate y(Integer y) {
    this.y = y;
    return this;
  }

   /**
   * Get y
   * @return y
  **/
  @ApiModelProperty(value = "")
  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  public CellUpdate w(Integer w) {
    this.w = w;
    return this;
  }

   /**
   * Get w
   * @return w
  **/
  @ApiModelProperty(value = "")
  public Integer getW() {
    return w;
  }

  public void setW(Integer w) {
    this.w = w;
  }

  public CellUpdate h(Integer h) {
    this.h = h;
    return this;
  }

   /**
   * Get h
   * @return h
  **/
  @ApiModelProperty(value = "")
  public Integer getH() {
    return h;
  }

  public void setH(Integer h) {
    this.h = h;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CellUpdate cellUpdate = (CellUpdate) o;
    return Objects.equals(this.x, cellUpdate.x) &&
        Objects.equals(this.y, cellUpdate.y) &&
        Objects.equals(this.w, cellUpdate.w) &&
        Objects.equals(this.h, cellUpdate.h);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, w, h);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CellUpdate {\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    w: ").append(toIndentedString(w)).append("\n");
    sb.append("    h: ").append(toIndentedString(h)).append("\n");
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

