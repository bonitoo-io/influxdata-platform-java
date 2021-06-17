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
 * PermissionResource
 */

public class PermissionResource {
  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    AUTHORIZATIONS("authorizations"),
    
    BUCKETS("buckets"),
    
    DASHBOARDS("dashboards"),
    
    ORGS("orgs"),
    
    SOURCES("sources"),
    
    TASKS("tasks"),
    
    TELEGRAFS("telegrafs"),
    
    USERS("users"),
    
    VARIABLES("variables"),
    
    SCRAPERS("scrapers"),
    
    SECRETS("secrets"),
    
    LABELS("labels"),
    
    VIEWS("views"),
    
    DOCUMENTS("documents"),
    
    NOTIFICATIONRULES("notificationRules"),
    
    NOTIFICATIONENDPOINTS("notificationEndpoints"),
    
    CHECKS("checks"),
    
    DBRP("dbrp"),
    
    NOTEBOOKS("notebooks"),
    
    ANNOTATIONS("annotations");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_ORG_I_D = "orgID";
  @SerializedName(SERIALIZED_NAME_ORG_I_D)
  private String orgID;

  public static final String SERIALIZED_NAME_ORG = "org";
  @SerializedName(SERIALIZED_NAME_ORG)
  private String org;

  public PermissionResource type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public PermissionResource id(String id) {
    this.id = id;
    return this;
  }

   /**
   * If ID is set that is a permission for a specific resource. if it is not set it is a permission for all resources of that resource type.
   * @return id
  **/
  @ApiModelProperty(value = "If ID is set that is a permission for a specific resource. if it is not set it is a permission for all resources of that resource type.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PermissionResource name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Optional name of the resource if the resource has a name field.
   * @return name
  **/
  @ApiModelProperty(value = "Optional name of the resource if the resource has a name field.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PermissionResource orgID(String orgID) {
    this.orgID = orgID;
    return this;
  }

   /**
   * If orgID is set that is a permission for all resources owned my that org. if it is not set it is a permission for all resources of that resource type.
   * @return orgID
  **/
  @ApiModelProperty(value = "If orgID is set that is a permission for all resources owned my that org. if it is not set it is a permission for all resources of that resource type.")
  public String getOrgID() {
    return orgID;
  }

  public void setOrgID(String orgID) {
    this.orgID = orgID;
  }

  public PermissionResource org(String org) {
    this.org = org;
    return this;
  }

   /**
   * Optional name of the organization of the organization with orgID.
   * @return org
  **/
  @ApiModelProperty(value = "Optional name of the organization of the organization with orgID.")
  public String getOrg() {
    return org;
  }

  public void setOrg(String org) {
    this.org = org;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PermissionResource resource = (PermissionResource) o;
    return Objects.equals(this.type, resource.type) &&
        Objects.equals(this.id, resource.id) &&
        Objects.equals(this.name, resource.name) &&
        Objects.equals(this.orgID, resource.orgID) &&
        Objects.equals(this.org, resource.org);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, name, orgID, org);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PermissionResource {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orgID: ").append(toIndentedString(orgID)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
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

