package org.influxdata.client.service;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.influxdata.client.domain.AddResourceMemberRequestBody;
import org.influxdata.client.domain.Error;
import org.influxdata.client.domain.Label;
import org.influxdata.client.domain.LabelMapping;
import org.influxdata.client.domain.LabelResponse;
import org.influxdata.client.domain.LabelsResponse;
import org.influxdata.client.domain.ResourceMember;
import org.influxdata.client.domain.ResourceMembers;
import org.influxdata.client.domain.ResourceOwner;
import org.influxdata.client.domain.ResourceOwners;
import org.influxdata.client.domain.ScraperTargetRequest;
import org.influxdata.client.domain.ScraperTargetResponse;
import org.influxdata.client.domain.ScraperTargetResponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ScraperTargetsService {
  /**
   * get all scraper targets
   * 
   * @return Call&lt;ScraperTargetResponses&gt;
   */
  @GET("scrapers")
  Call<ScraperTargetResponses> scrapersGet();
    

  /**
   * create a scraper target
   * 
   * @param scraperTargetRequest scraper target to create (required)
   * @return Call&lt;ScraperTargetResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("scrapers")
  Call<ScraperTargetResponse> scrapersPost(
    @retrofit2.http.Body ScraperTargetRequest scraperTargetRequest
  );

  /**
   * delete a scraper target
   * 
   * @param scraperTargetID id of the scraper target (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("scrapers/{scraperTargetID}")
  Call<Void> scrapersScraperTargetIDDelete(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Retrieve a  scraper target
   * 
   * @param scraperTargetID ID of of the scraper target to get (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ScraperTargetResponse&gt;
   */
  @GET("scrapers/{scraperTargetID}")
  Call<ScraperTargetResponse> scrapersScraperTargetIDGet(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * list all labels for a scraper targets
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;LabelsResponse&gt;
   */
  @GET("scrapers/{scraperTargetID}/labels")
  Call<LabelsResponse> scrapersScraperTargetIDLabelsGet(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * delete a label from a scraper target
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param labelID ID of the label (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("scrapers/{scraperTargetID}/labels/{labelID}")
  Call<Void> scrapersScraperTargetIDLabelsLabelIDDelete(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Path("labelID") String labelID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * update a label from a scraper target
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param labelID ID of the label (required)
   * @param label label update to apply (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("scrapers/{scraperTargetID}/labels/{labelID}")
  Call<Void> scrapersScraperTargetIDLabelsLabelIDPatch(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Path("labelID") String labelID, @retrofit2.http.Body Label label, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * add a label to a scraper target
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param labelMapping label to add (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;LabelResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("scrapers/{scraperTargetID}/labels")
  Call<LabelResponse> scrapersScraperTargetIDLabelsPost(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Body LabelMapping labelMapping, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * List all users with member privileges for a scraper target
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceMembers&gt;
   */
  @GET("scrapers/{scraperTargetID}/members")
  Call<ResourceMembers> scrapersScraperTargetIDMembersGet(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Add scraper target member
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param addResourceMemberRequestBody user to add as member (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceMember&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("scrapers/{scraperTargetID}/members")
  Call<ResourceMember> scrapersScraperTargetIDMembersPost(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Body AddResourceMemberRequestBody addResourceMemberRequestBody, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * removes a member from a scraper target
   * 
   * @param userID ID of member to remove (required)
   * @param scraperTargetID ID of the scraper target (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("scrapers/{scraperTargetID}/members/{userID}")
  Call<Void> scrapersScraperTargetIDMembersUserIDDelete(
    @retrofit2.http.Path("userID") String userID, @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * List all owners of a scraper target
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceOwners&gt;
   */
  @GET("scrapers/{scraperTargetID}/owners")
  Call<ResourceOwners> scrapersScraperTargetIDOwnersGet(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Add scraper target owner
   * 
   * @param scraperTargetID ID of the scraper target (required)
   * @param addResourceMemberRequestBody user to add as owner (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ResourceOwner&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("scrapers/{scraperTargetID}/owners")
  Call<ResourceOwner> scrapersScraperTargetIDOwnersPost(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Body AddResourceMemberRequestBody addResourceMemberRequestBody, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * removes an owner from a scraper target
   * 
   * @param userID ID of owner to remove (required)
   * @param scraperTargetID ID of the scraper target (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("scrapers/{scraperTargetID}/owners/{userID}")
  Call<Void> scrapersScraperTargetIDOwnersUserIDDelete(
    @retrofit2.http.Path("userID") String userID, @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * update a scraper target
   * 
   * @param scraperTargetID id of the scraper target (required)
   * @param scraperTargetRequest scraper target update to apply (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;ScraperTargetResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("scrapers/{scraperTargetID}")
  Call<ScraperTargetResponse> scrapersScraperTargetIDPatch(
    @retrofit2.http.Path("scraperTargetID") String scraperTargetID, @retrofit2.http.Body ScraperTargetRequest scraperTargetRequest, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

}
