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

/**
 * dialect are options to change the default CSV output format; https://www.w3.org/TR/2015/REC-tabular-metadata-20151217/#dialect-descriptions
 */
@ApiModel(description = "dialect are options to change the default CSV output format; https://www.w3.org/TR/2015/REC-tabular-metadata-20151217/#dialect-descriptions")
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-21T09:57:56.036+01:00[Europe/Prague]")
public class Dialect {
  public static final String SERIALIZED_NAME_HEADER = "header";
  @SerializedName(SERIALIZED_NAME_HEADER)
  private Boolean header = true;

  public static final String SERIALIZED_NAME_DELIMITER = "delimiter";
  @SerializedName(SERIALIZED_NAME_DELIMITER)
  private String delimiter = ",";

  /**
   * Gets or Sets annotations
   */
  @JsonAdapter(AnnotationsEnum.Adapter.class)
  public enum AnnotationsEnum {
    GROUP("group"),
    
    DATATYPE("datatype"),
    
    DEFAULT("default");

    private String value;

    AnnotationsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AnnotationsEnum fromValue(String text) {
      for (AnnotationsEnum b : AnnotationsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<AnnotationsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AnnotationsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AnnotationsEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return AnnotationsEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_ANNOTATIONS = "annotations";
  @SerializedName(SERIALIZED_NAME_ANNOTATIONS)
  private List<AnnotationsEnum> annotations = new ArrayList<>();

  public static final String SERIALIZED_NAME_COMMENT_PREFIX = "commentPrefix";
  @SerializedName(SERIALIZED_NAME_COMMENT_PREFIX)
  private String commentPrefix = "#";

  /**
   * format of timestamps
   */
  @JsonAdapter(DateTimeFormatEnum.Adapter.class)
  public enum DateTimeFormatEnum {
    RFC3339("RFC3339"),
    
    RFC3339NANO("RFC3339Nano");

    private String value;

    DateTimeFormatEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DateTimeFormatEnum fromValue(String text) {
      for (DateTimeFormatEnum b : DateTimeFormatEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<DateTimeFormatEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DateTimeFormatEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DateTimeFormatEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return DateTimeFormatEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_DATE_TIME_FORMAT = "dateTimeFormat";
  @SerializedName(SERIALIZED_NAME_DATE_TIME_FORMAT)
  private DateTimeFormatEnum dateTimeFormat = DateTimeFormatEnum.RFC3339;

  public Dialect header(Boolean header) {
    this.header = header;
    return this;
  }

   /**
   * if true, the results will contain a header row
   * @return header
  **/
  @ApiModelProperty(value = "if true, the results will contain a header row")
  public Boolean isHeader() {
    return header;
  }

  public void setHeader(Boolean header) {
    this.header = header;
  }

  public Dialect delimiter(String delimiter) {
    this.delimiter = delimiter;
    return this;
  }

   /**
   * separator between cells; the default is ,
   * @return delimiter
  **/
  @ApiModelProperty(value = "separator between cells; the default is ,")
  public String getDelimiter() {
    return delimiter;
  }

  public void setDelimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  public Dialect annotations(List<AnnotationsEnum> annotations) {
    this.annotations = annotations;
    return this;
  }

  public Dialect addAnnotationsItem(AnnotationsEnum annotationsItem) {
    if (this.annotations == null) {
      this.annotations = new ArrayList<>();
    }
    this.annotations.add(annotationsItem);
    return this;
  }

   /**
   * https://www.w3.org/TR/2015/REC-tabular-data-model-20151217/#columns
   * @return annotations
  **/
  @ApiModelProperty(value = "https://www.w3.org/TR/2015/REC-tabular-data-model-20151217/#columns")
  public List<AnnotationsEnum> getAnnotations() {
    return annotations;
  }

  public void setAnnotations(List<AnnotationsEnum> annotations) {
    this.annotations = annotations;
  }

  public Dialect commentPrefix(String commentPrefix) {
    this.commentPrefix = commentPrefix;
    return this;
  }

   /**
   * character prefixed to comment strings
   * @return commentPrefix
  **/
  @ApiModelProperty(value = "character prefixed to comment strings")
  public String getCommentPrefix() {
    return commentPrefix;
  }

  public void setCommentPrefix(String commentPrefix) {
    this.commentPrefix = commentPrefix;
  }

  public Dialect dateTimeFormat(DateTimeFormatEnum dateTimeFormat) {
    this.dateTimeFormat = dateTimeFormat;
    return this;
  }

   /**
   * format of timestamps
   * @return dateTimeFormat
  **/
  @ApiModelProperty(value = "format of timestamps")
  public DateTimeFormatEnum getDateTimeFormat() {
    return dateTimeFormat;
  }

  public void setDateTimeFormat(DateTimeFormatEnum dateTimeFormat) {
    this.dateTimeFormat = dateTimeFormat;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dialect dialect = (Dialect) o;
    return Objects.equals(this.header, dialect.header) &&
        Objects.equals(this.delimiter, dialect.delimiter) &&
        Objects.equals(this.annotations, dialect.annotations) &&
        Objects.equals(this.commentPrefix, dialect.commentPrefix) &&
        Objects.equals(this.dateTimeFormat, dialect.dateTimeFormat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, delimiter, annotations, commentPrefix, dateTimeFormat);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dialect {\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    delimiter: ").append(toIndentedString(delimiter)).append("\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
    sb.append("    commentPrefix: ").append(toIndentedString(commentPrefix)).append("\n");
    sb.append("    dateTimeFormat: ").append(toIndentedString(dateTimeFormat)).append("\n");
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

