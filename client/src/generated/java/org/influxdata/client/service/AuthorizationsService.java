package org.influxdata.client.service;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.influxdata.client.domain.Authorization;
import org.influxdata.client.domain.Authorizations;
import org.influxdata.client.domain.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AuthorizationsService {
  /**
   * Delete a authorization
   * 
   * @param authID ID of authorization to delete (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v2/authorizations/{authID}")
  Call<Void> authorizationsAuthIDDelete(
    @retrofit2.http.Path("authID") String authID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * Retrieve an authorization
   * 
   * @param authID ID of authorization to get (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Authorization&gt;
   */
  @GET("api/v2/authorizations/{authID}")
  Call<Authorization> authorizationsAuthIDGet(
    @retrofit2.http.Path("authID") String authID, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * update authorization to be active or inactive. requests using an inactive authorization will be rejected.
   * 
   * @param authID ID of authorization to update (required)
   * @param authorization authorization to update to apply (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Authorization&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/v2/authorizations/{authID}")
  Call<Authorization> authorizationsAuthIDPatch(
    @retrofit2.http.Path("authID") String authID, @retrofit2.http.Body Authorization authorization, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

  /**
   * List all authorizations
   * 
   * @param zapTraceSpan OpenTracing span context (optional)
   * @param userID filter authorizations belonging to a user id (optional)
   * @param user filter authorizations belonging to a user name (optional)
   * @return Call&lt;Authorizations&gt;
   */
  @GET("api/v2/authorizations")
  Call<Authorizations> authorizationsGet(
    @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan, @retrofit2.http.Query("userID") String userID, @retrofit2.http.Query("user") String user
  );

  /**
   * Create an authorization
   * 
   * @param authorization authorization to create (required)
   * @param zapTraceSpan OpenTracing span context (optional)
   * @return Call&lt;Authorization&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/v2/authorizations")
  Call<Authorization> authorizationsPost(
    @retrofit2.http.Body Authorization authorization, @retrofit2.http.Header("Zap-Trace-Span") String zapTraceSpan
  );

}
