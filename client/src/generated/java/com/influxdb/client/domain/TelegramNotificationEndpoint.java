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
import java.util.List;

/**
 * TelegramNotificationEndpoint
 */

public class TelegramNotificationEndpoint extends NotificationEndpoint {
  public static final String SERIALIZED_NAME_TOKEN = "token";
  @SerializedName(SERIALIZED_NAME_TOKEN)
  private String token;

  public static final String SERIALIZED_NAME_CHANNEL = "channel";
  @SerializedName(SERIALIZED_NAME_CHANNEL)
  private String channel;

  public TelegramNotificationEndpoint token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Specifies the Telegram bot token. See https://core.telegram.org/bots#creating-a-new-bot .
   * @return token
  **/
  @ApiModelProperty(required = true, value = "Specifies the Telegram bot token. See https://core.telegram.org/bots#creating-a-new-bot .")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public TelegramNotificationEndpoint channel(String channel) {
    this.channel = channel;
    return this;
  }

   /**
   * ID of the telegram channel, a chat_id in https://core.telegram.org/bots/api#sendmessage .
   * @return channel
  **/
  @ApiModelProperty(required = true, value = "ID of the telegram channel, a chat_id in https://core.telegram.org/bots/api#sendmessage .")
  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelegramNotificationEndpoint telegramNotificationEndpoint = (TelegramNotificationEndpoint) o;
    return Objects.equals(this.token, telegramNotificationEndpoint.token) &&
        Objects.equals(this.channel, telegramNotificationEndpoint.channel) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, channel, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelegramNotificationEndpoint {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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

