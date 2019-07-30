## 1.0.0.M2 [unreleased]

### Breaking Changes
1. [#40](https://github.com/influxdata/influxdb-client-java/issues/40): The client is hosted in Maven Central repository
    - Repackaged from `org.influxdata` to `com.influxdb`
    - Changed _groupId_ from `org.influxdata` to `com.influxdb`
    - Snapshots are located in the _OSS Snapshot repository_: `https://oss.sonatype.org/content/repositories/snapshots/`

### Features
1. [#34](https://github.com/bonitoo-io/influxdb-client-java/issues/34): Auto-configure client from configuration file
1. [#35](https://github.com/bonitoo-io/influxdb-client-java/issues/35): Possibility to specify default tags
1. [#41](https://github.com/bonitoo-io/influxdb-client-java/issues/41): Synchronous blocking API to Write time-series data into InfluxDB 2.0

### Bugs
1. [#43](https://github.com/bonitoo-io/influxdb-client-java/issues/43): The data point without field should be ignored

### CI
1. [#37](https://github.com/bonitoo-io/influxdb-client-java/issues/37): Switch CI from oraclejdk to openjdk 

## 1.0.0.M1

### Features
1. [client-java](https://github.com/bonitoo-io/influxdb-client-java/tree/master/client#influxdb-client-java): The reference Java client that allows query, write and InfluxDB 2.0 management
1. [client-reactive](https://github.com/bonitoo-io/influxdb-client-java/tree/master/client-reactive#influxdb-client-reactive): The reference RxJava client for the InfluxDB 2.0 that allows query and write in a reactive way
1. [client-kotlin](https://github.com/bonitoo-io/influxdb-client-java/tree/master/client-kotlin#influxdb-client-kotlin): The reference Kotlin client that allows query and write for the InfluxDB 2.0 by Kotlin Channel coroutines
1. [client-scala](https://github.com/bonitoo-io/influxdb-client-java/tree/master/client-scala#influxdb-client-scala): The reference Scala client that allows query and write for the InfluxDB 2.0 by Akka Streams
1. [client-legacy](https://github.com/bonitoo-io/influxdb-client-java/tree/master/client-legacy#influxdb-client-flux):  The reference Java client that allows you to perform Flux queries against InfluxDB 1.7+
1. [flux-dsl](https://github.com/bonitoo-io/influxdb-client-java/tree/master/flux-dsl#flux-dsl): A Java query builder for the Flux language
