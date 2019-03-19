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
 * Error
 */
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-19T14:55:47.021+01:00[Europe/Prague]")
public class Error {
  /**
   * code is the machine-readable error code.
   */
  @JsonAdapter(CodeEnum.Adapter.class)
  public enum CodeEnum {
    INTERNAL_ERROR("internal error"),
    
    NOT_FOUND("not found"),
    
    CONFLICT("conflict"),
    
    INVALID("invalid"),
    
    UNPROCESSABLE_ENTITY("unprocessable entity"),
    
    EMPTY_VALUE("empty value"),
    
    UNAVAILABLE("unavailable"),
    
    FORBIDDEN("forbidden"),
    
    UNAUTHORIZED("unauthorized"),
    
    METHOD_NOT_ALLOWED("method not allowed");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CodeEnum fromValue(String text) {
      for (CodeEnum b : CodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<CodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CodeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return CodeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_CODE = "code";
  @SerializedName(SERIALIZED_NAME_CODE)
  private CodeEnum code = null;

  public static final String SERIALIZED_NAME_MESSAGE = "message";
  @SerializedName(SERIALIZED_NAME_MESSAGE)
  private String message = null;

  public static final String SERIALIZED_NAME_OP = "op";
  @SerializedName(SERIALIZED_NAME_OP)
  private String op = null;

  public static final String SERIALIZED_NAME_ERR = "err";
  @SerializedName(SERIALIZED_NAME_ERR)
  private String err = null;

   /**
   * code is the machine-readable error code.
   * @return code
  **/
  @ApiModelProperty(required = true, value = "code is the machine-readable error code.")
  public CodeEnum getCode() {
    return code;
  }

   /**
   * message is a human-readable message.
   * @return message
  **/
  @ApiModelProperty(required = true, value = "message is a human-readable message.")
  public String getMessage() {
    return message;
  }

   /**
   * op describes the logical code operation during error. Useful for debugging.
   * @return op
  **/
  @ApiModelProperty(value = "op describes the logical code operation during error. Useful for debugging.")
  public String getOp() {
    return op;
  }

   /**
   * err is a stack of errors that occurred during processing of the request. Useful for debugging.
   * @return err
  **/
  @ApiModelProperty(value = "err is a stack of errors that occurred during processing of the request. Useful for debugging.")
  public String getErr() {
    return err;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.op, error.op) &&
        Objects.equals(this.err, error.err);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, op, err);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    err: ").append(toIndentedString(err)).append("\n");
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

