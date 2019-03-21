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
import org.influxdata.client.domain.ScraperTargetRequest;
import org.influxdata.client.domain.ScraperTargetResponseLinks;

/**
 * ScraperTargetResponse
 */
@javax.annotation.Generated(value = "org.influxdata.codegen.InfluxJavaGenerator", date = "2019-03-21T09:57:56.036+01:00[Europe/Prague]")
public class ScraperTargetResponse extends ScraperTargetRequest {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id = null;

  public static final String SERIALIZED_NAME_ORGANIZATION = "organization";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION)
  private String organization = null;

  public static final String SERIALIZED_NAME_BUCKET = "bucket";
  @SerializedName(SERIALIZED_NAME_BUCKET)
  private String bucket = null;

  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private ScraperTargetResponseLinks links = null;

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public ScraperTargetResponse organization(String organization) {
    this.organization = organization;
    return this;
  }

   /**
   * name of the organization
   * @return organization
  **/
  @ApiModelProperty(value = "name of the organization")
  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public ScraperTargetResponse bucket(String bucket) {
    this.bucket = bucket;
    return this;
  }

   /**
   * name of the bucket
   * @return bucket
  **/
  @ApiModelProperty(value = "name of the bucket")
  public String getBucket() {
    return bucket;
  }

  public void setBucket(String bucket) {
    this.bucket = bucket;
  }

  public ScraperTargetResponse links(ScraperTargetResponseLinks links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public ScraperTargetResponseLinks getLinks() {
    return links;
  }

  public void setLinks(ScraperTargetResponseLinks links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScraperTargetResponse scraperTargetResponse = (ScraperTargetResponse) o;
    return Objects.equals(this.id, scraperTargetResponse.id) &&
        Objects.equals(this.organization, scraperTargetResponse.organization) &&
        Objects.equals(this.bucket, scraperTargetResponse.bucket) &&
        Objects.equals(this.links, scraperTargetResponse.links) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, organization, bucket, links, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScraperTargetResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    bucket: ").append(toIndentedString(bucket)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

