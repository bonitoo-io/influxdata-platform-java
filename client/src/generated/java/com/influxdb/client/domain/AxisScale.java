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
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Scale is the axis formatting scale. Supported: \&quot;log\&quot;, \&quot;linear\&quot;
 */
@JsonAdapter(AxisScale.Adapter.class)
public enum AxisScale {
  
  LOG("log"),
  
  LINEAR("linear");

  private String value;

  AxisScale(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static AxisScale fromValue(String text) {
    for (AxisScale b : AxisScale.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<AxisScale> {
    @Override
    public void write(final JsonWriter jsonWriter, final AxisScale enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public AxisScale read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return AxisScale.fromValue(String.valueOf(value));
    }
  }
}

