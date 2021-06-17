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
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.NotificationEndpointBase;
import com.influxdb.client.domain.NotificationEndpointBaseLinks;
import com.influxdb.client.domain.NotificationEndpointType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HTTPNotificationEndpoint
 */

public class HTTPNotificationEndpoint extends NotificationEndpoint {
  public static final String SERIALIZED_NAME_URL = "url";
  @SerializedName(SERIALIZED_NAME_URL)
  private String url;

  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;

  public static final String SERIALIZED_NAME_PASSWORD = "password";
  @SerializedName(SERIALIZED_NAME_PASSWORD)
  private String password;

  public static final String SERIALIZED_NAME_TOKEN = "token";
  @SerializedName(SERIALIZED_NAME_TOKEN)
  private String token;

  /**
   * Gets or Sets method
   */
  @JsonAdapter(MethodEnum.Adapter.class)
  public enum MethodEnum {
    POST("POST"),
    
    GET("GET"),
    
    PUT("PUT");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MethodEnum fromValue(String text) {
      for (MethodEnum b : MethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<MethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MethodEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return MethodEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_METHOD = "method";
  @SerializedName(SERIALIZED_NAME_METHOD)
  private MethodEnum method;

  /**
   * Gets or Sets authMethod
   */
  @JsonAdapter(AuthMethodEnum.Adapter.class)
  public enum AuthMethodEnum {
    NONE("none"),
    
    BASIC("basic"),
    
    BEARER("bearer");

    private String value;

    AuthMethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AuthMethodEnum fromValue(String text) {
      for (AuthMethodEnum b : AuthMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<AuthMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AuthMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AuthMethodEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return AuthMethodEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_AUTH_METHOD = "authMethod";
  @SerializedName(SERIALIZED_NAME_AUTH_METHOD)
  private AuthMethodEnum authMethod;

  public static final String SERIALIZED_NAME_CONTENT_TEMPLATE = "contentTemplate";
  @SerializedName(SERIALIZED_NAME_CONTENT_TEMPLATE)
  private String contentTemplate;

  public static final String SERIALIZED_NAME_HEADERS = "headers";
  @SerializedName(SERIALIZED_NAME_HEADERS)
  private Map<String, String> headers = new HashMap<>();

  public HTTPNotificationEndpoint url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(required = true, value = "")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public HTTPNotificationEndpoint username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public HTTPNotificationEndpoint password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public HTTPNotificationEndpoint token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(value = "")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public HTTPNotificationEndpoint method(MethodEnum method) {
    this.method = method;
    return this;
  }

   /**
   * Get method
   * @return method
  **/
  @ApiModelProperty(required = true, value = "")
  public MethodEnum getMethod() {
    return method;
  }

  public void setMethod(MethodEnum method) {
    this.method = method;
  }

  public HTTPNotificationEndpoint authMethod(AuthMethodEnum authMethod) {
    this.authMethod = authMethod;
    return this;
  }

   /**
   * Get authMethod
   * @return authMethod
  **/
  @ApiModelProperty(required = true, value = "")
  public AuthMethodEnum getAuthMethod() {
    return authMethod;
  }

  public void setAuthMethod(AuthMethodEnum authMethod) {
    this.authMethod = authMethod;
  }

  public HTTPNotificationEndpoint contentTemplate(String contentTemplate) {
    this.contentTemplate = contentTemplate;
    return this;
  }

   /**
   * Get contentTemplate
   * @return contentTemplate
  **/
  @ApiModelProperty(value = "")
  public String getContentTemplate() {
    return contentTemplate;
  }

  public void setContentTemplate(String contentTemplate) {
    this.contentTemplate = contentTemplate;
  }

  public HTTPNotificationEndpoint headers(Map<String, String> headers) {
    this.headers = headers;
    return this;
  }

  public HTTPNotificationEndpoint putHeadersItem(String key, String headersItem) {
    if (this.headers == null) {
      this.headers = new HashMap<>();
    }
    this.headers.put(key, headersItem);
    return this;
  }

   /**
   * Customized headers.
   * @return headers
  **/
  @ApiModelProperty(value = "Customized headers.")
  public Map<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HTTPNotificationEndpoint htTPNotificationEndpoint = (HTTPNotificationEndpoint) o;
    return Objects.equals(this.url, htTPNotificationEndpoint.url) &&
        Objects.equals(this.username, htTPNotificationEndpoint.username) &&
        Objects.equals(this.password, htTPNotificationEndpoint.password) &&
        Objects.equals(this.token, htTPNotificationEndpoint.token) &&
        Objects.equals(this.method, htTPNotificationEndpoint.method) &&
        Objects.equals(this.authMethod, htTPNotificationEndpoint.authMethod) &&
        Objects.equals(this.contentTemplate, htTPNotificationEndpoint.contentTemplate) &&
        Objects.equals(this.headers, htTPNotificationEndpoint.headers) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, username, password, token, method, authMethod, contentTemplate, headers, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HTTPNotificationEndpoint {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    authMethod: ").append(toIndentedString(authMethod)).append("\n");
    sb.append("    contentTemplate: ").append(toIndentedString(contentTemplate)).append("\n");
    sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
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

