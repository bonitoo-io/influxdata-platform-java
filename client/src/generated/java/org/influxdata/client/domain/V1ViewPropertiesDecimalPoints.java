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
 * decimal points indicates whether and how many digits to show after decimal point
 */
@ApiModel(description = "decimal points indicates whether and how many digits to show after decimal point")

public class V1ViewPropertiesDecimalPoints {
  public static final String SERIALIZED_NAME_IS_ENFORCED = "isEnforced";
  @SerializedName(SERIALIZED_NAME_IS_ENFORCED)
  private Boolean isEnforced = null;

  public static final String SERIALIZED_NAME_DIGITS = "digits";
  @SerializedName(SERIALIZED_NAME_DIGITS)
  private Integer digits = null;

  public V1ViewPropertiesDecimalPoints isEnforced(Boolean isEnforced) {
    this.isEnforced = isEnforced;
    return this;
  }

   /**
   * Indicates whether decimal point setting should be enforced
   * @return isEnforced
  **/
  @ApiModelProperty(value = "Indicates whether decimal point setting should be enforced")
  public Boolean isIsEnforced() {
    return isEnforced;
  }

  public void setIsEnforced(Boolean isEnforced) {
    this.isEnforced = isEnforced;
  }

  public V1ViewPropertiesDecimalPoints digits(Integer digits) {
    this.digits = digits;
    return this;
  }

   /**
   * The number of digists after decimal to display
   * @return digits
  **/
  @ApiModelProperty(value = "The number of digists after decimal to display")
  public Integer getDigits() {
    return digits;
  }

  public void setDigits(Integer digits) {
    this.digits = digits;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ViewPropertiesDecimalPoints v1ViewPropertiesDecimalPoints = (V1ViewPropertiesDecimalPoints) o;
    return Objects.equals(this.isEnforced, v1ViewPropertiesDecimalPoints.isEnforced) &&
        Objects.equals(this.digits, v1ViewPropertiesDecimalPoints.digits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isEnforced, digits);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ViewPropertiesDecimalPoints {\n");
    sb.append("    isEnforced: ").append(toIndentedString(isEnforced)).append("\n");
    sb.append("    digits: ").append(toIndentedString(digits)).append("\n");
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

