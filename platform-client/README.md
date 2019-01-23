# influxdata-platform-java
[![Build Status](https://travis-ci.org/bonitoo-io/influxdata-platform-java.svg?branch=master)](https://travis-ci.org/bonitoo-io/influxdata-platform-java)
[![codecov](https://codecov.io/gh/bonitoo-io/influxdata-platform-java/branch/master/graph/badge.svg)](https://codecov.io/gh/bonitoo-io/influxdata-platform-java)
[![License](https://img.shields.io/github/license/bonitoo-io/influxdata-platform-java.svg)](https://github.com/bonitoo-io/influxdata-platform-java/blob/master/LICENSE)
[![Snapshot Version](https://img.shields.io/nexus/s/https/apitea.com/nexus/org.influxdata/influxdata-platform-java.svg)](https://apitea.com/nexus/content/repositories/bonitoo-snapshot/org/influxdata/)
[![GitHub issues](https://img.shields.io/github/issues-raw/bonitoo-io/influxdata-platform-java.svg)](https://github.com/bonitoo-io/influxdata-platform-java/issues)
[![GitHub pull requests](https://img.shields.io/github/issues-pr-raw/bonitoo-io/influxdata-platform-java.svg)](https://github.com/bonitoo-io/influxdata-platform-java/pulls)

This module contains the Java client for the InfluxData Platform OSS 2.0.

> This library is under development and no stable version has been released yet.  
> The API can change at any moment.

### Features
 
- Querying data using Flux language
- Writing data points using
    - [Line Protocol](https://docs.influxdata.com/influxdb/v1.6/write_protocols/line_protocol_tutorial/) 
    - [Point object](https://github.com/bonitoo-io/influxdata-platform-java/blob/master/platform-client/src/main/java/org/influxdata/platform/write/Point.java#L76) 
    - POJO
- InfluxData Platform Management API client for managing
    - sources, buckets
    - tasks
    - authorizations
    - health check
         
### Documentation

#### Data query using Flux language

#### Write data

#### Management API