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
import org.influxdata.client.domain.TelegrafPluginInputRedisConfig;

/**
 * TelegrafPluginInputRedis
 */
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-18T13:18:15.931+01:00[Europe/Prague]")
public class TelegrafPluginInputRedis extends TelegrafPlugin<TelegrafPluginInputRedis.NameEnum, TelegrafPluginInputRedisConfig> {
  /**
   * Gets or Sets name
   */
  @JsonAdapter(NameEnum.Adapter.class)
  public enum NameEnum {
    REDIS("redis");

    private String value;

    NameEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static NameEnum fromValue(String text) {
      for (NameEnum b : NameEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<NameEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final NameEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public NameEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return NameEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_COMMENT = "comment";
  @SerializedName(SERIALIZED_NAME_COMMENT)
  private String comment = null;

  public TelegrafPluginInputRedis() {
    setName(TelegrafPluginInputRedis.NameEnum.REDIS);
    setType(TelegrafRequestPlugin.TypeEnum.INPUT);
  }
      
  public TelegrafPluginInputRedis comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(value = "")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelegrafPluginInputRedis telegrafPluginInputRedis = (TelegrafPluginInputRedis) o;
    return Objects.equals(this.comment, telegrafPluginInputRedis.comment) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelegrafPluginInputRedis {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

