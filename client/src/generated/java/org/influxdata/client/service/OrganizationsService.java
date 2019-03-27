package org.influxdata.client.service;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.influxdata.client.domain.AddResourceMemberRequestBody;
import org.influxdata.client.domain.Error;
import org.influxdata.client.domain.LabelMapping;
import org.influxdata.client.domain.LabelResponse;
import org.influxdata.client.domain.LabelsResponse;
import org.influxdata.client.domain.OperationLogs;
import org.influxdata.client.domain.Organization;
import org.influxdata.client.domain.Organizations;
import org.influxdata.client.domain.ResourceMember;
import org.influxdata.client.domain.ResourceMembers;
import org.influxdata.client.domain.ResourceOwner;
import org.influxdata.client.domain.ResourceOwners;
import org.influxdata.client.domain.SecretKeys;
import org.influxdata.client.domain.SecretKeysResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrganizationsService {
  /**
   * List all organizations
   * 
   * @param zapTraceSpan OpenTracing span context (optional)
   * @param org filter organizations to a specific organization name (optional)
   * @param orgID filter organizations to a specific organization ID (optional)
   * @return Call&lt;Organizations&gt;
   */
  @GET("api/v2/orgs")
  Call<Organizations> orgsGet(
    @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan, @retrofit2.http.Query("org") String org, @retrofit2.http.Query("orgID") String orgID
  );

  /**
   * Delete an organization
   * 
   * @param orgID ID of organization to delete (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v2/orgs/{orgID}")
  Call<Void> orgsOrgIDDelete(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Retrieve an organization
   * 
   * @param orgID ID of organization to get (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Organization&gt;
   */
  @GET("api/v2/orgs/{orgID}")
  Call<Organization> orgsOrgIDGet(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * list all labels for a organization
   * 
   * @param orgID ID of the organization (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;LabelsResponse&gt;
   */
  @GET("api/v2/orgs/{orgID}/labels")
  Call<LabelsResponse> orgsOrgIDLabelsGet(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * delete a label from an organization
   * 
   * @param orgID ID of the organization (required)
   * @param labelID the label id (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v2/orgs/{orgID}/labels/{labelID}")
  Call<Void> orgsOrgIDLabelsLabelIDDelete(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Path("labelID") String labelID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * add a label to an organization
   * 
   * @param orgID ID of the organization (required)
   * @param labelMapping label to add (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;LabelResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/orgs/{orgID}/labels")
  Call<LabelResponse> orgsOrgIDLabelsPost(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Body LabelMapping labelMapping, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Retrieve operation logs for an organization
   * 
   * @param orgID ID of the organization (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @param offset  (optional)
   * @param limit  (optional, default to 20)
   * @return Call&lt;OperationLogs&gt;
   */
  @GET("api/v2/orgs/{orgID}/logs")
  Call<OperationLogs> orgsOrgIDLogsGet(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan, @retrofit2.http.Query("offset") Integer offset, @retrofit2.http.Query("limit") Integer limit
  );

  /**
   * List all members of an organization
   * 
   * @param orgID ID of the organization (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceMembers&gt;
   */
  @GET("api/v2/orgs/{orgID}/members")
  Call<ResourceMembers> orgsOrgIDMembersGet(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Add organization member
   * 
   * @param orgID ID of the organization (required)
   * @param addResourceMemberRequestBody user to add as member (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceMember&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/orgs/{orgID}/members")
  Call<ResourceMember> orgsOrgIDMembersPost(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Body AddResourceMemberRequestBody addResourceMemberRequestBody, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * removes a member from an organization
   * 
   * @param userID ID of member to remove (required)
   * @param orgID ID of the organization (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v2/orgs/{orgID}/members/{userID}")
  Call<Void> orgsOrgIDMembersUserIDDelete(
    @retrofit2.http.Path("userID") String userID, @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * List all owners of an organization
   * 
   * @param orgID ID of the organization (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceOwners&gt;
   */
  @GET("api/v2/orgs/{orgID}/owners")
  Call<ResourceOwners> orgsOrgIDOwnersGet(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Add organization owner
   * 
   * @param orgID ID of the organization (required)
   * @param addResourceMemberRequestBody user to add as owner (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceOwner&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/orgs/{orgID}/owners")
  Call<ResourceOwner> orgsOrgIDOwnersPost(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Body AddResourceMemberRequestBody addResourceMemberRequestBody, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * removes an owner from an organization
   * 
   * @param userID ID of owner to remove (required)
   * @param orgID ID of the organization (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v2/orgs/{orgID}/owners/{userID}")
  Call<Void> orgsOrgIDOwnersUserIDDelete(
    @retrofit2.http.Path("userID") String userID, @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Update an organization
   * 
   * @param orgID ID of organization to get (required)
   * @param organization organization update to apply (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Organization&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/v2/orgs/{orgID}")
  Call<Organization> orgsOrgIDPatch(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Body Organization organization, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * delete provided secrets
   * 
   * @param orgID ID of the organization (required)
   * @param secretKeys secret key to deleted (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/orgs/{orgID}/secrets/delete")
  Call<Void> orgsOrgIDSecretsDeletePost(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Body SecretKeys secretKeys, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * List all secret keys for an organization
   * 
   * @param orgID ID of the organization (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;SecretKeysResponse&gt;
   */
  @GET("api/v2/orgs/{orgID}/secrets")
  Call<SecretKeysResponse> orgsOrgIDSecretsGet(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Apply patch to the provided secrets
   * 
   * @param orgID ID of the organization (required)
   * @param requestBody secret key value pairs to update/add (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/v2/orgs/{orgID}/secrets")
  Call<Void> orgsOrgIDSecretsPatch(
    @retrofit2.http.Path("orgID") String orgID, @retrofit2.http.Body Map<String, String> requestBody, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Create an organization
   * 
   * @param organization organization to create (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Organization&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/orgs")
  Call<Organization> orgsPost(
    @retrofit2.http.Body Organization organization, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

}
