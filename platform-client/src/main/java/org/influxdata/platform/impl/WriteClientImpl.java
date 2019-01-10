/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.influxdata.platform.impl;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.influxdata.platform.Arguments;
import org.influxdata.platform.WriteClient;
import org.influxdata.platform.option.WriteOptions;
import org.influxdata.platform.write.Point;
import org.influxdata.platform.write.event.AbstractWriteEvent;
import org.influxdata.platform.write.event.EventListener;
import org.influxdata.platform.write.event.ListenerRegistration;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @author Jakub Bednar (bednar@github) (15/10/2018 09:42)
 */
final class WriteClientImpl extends AbstractWriteClient implements WriteClient {

    private final PlatformService platformService;

    WriteClientImpl(@Nonnull final WriteOptions writeOptions,
                    @Nonnull final PlatformService platformService) {

        super(writeOptions, writeOptions.getWriteScheduler(), Schedulers.trampoline());

        this.platformService = platformService;
    }

    @Override
    public void writeRecord(@Nonnull final String bucket,
                            @Nonnull final String organizationId,
                            @Nonnull final ChronoUnit precision,
                            @Nullable final String record) {

        Arguments.checkNonEmpty(bucket, "bucket");
        Arguments.checkNonEmpty(organizationId, "organizationId");
        Arguments.checkNotNull(precision, "TimeUnit.precision is required");

        if (record == null) {
            return;
        }

        write(bucket, organizationId, precision, Flowable.just(new BatchWriteDataRecord(record)));
    }

    @Override
    public void writeRecords(@Nonnull final String bucket,
                             @Nonnull final String organizationId,
                             @Nonnull final ChronoUnit precision,
                             @Nonnull final List<String> records) {

        Arguments.checkNonEmpty(bucket, "bucket");
        Arguments.checkNonEmpty(organizationId, "organizationId");
        Arguments.checkNotNull(precision, "TimeUnit.precision is required");
        Arguments.checkNotNull(records, "records");

        Flowable<BatchWriteData> stream = Flowable.fromIterable(records).map(BatchWriteDataRecord::new);

        write(bucket, organizationId, precision, stream);
    }

    @Override
    public void writePoint(@Nonnull final String bucket,
                           @Nonnull final String organizationId,
                           @Nullable final Point point) {

        if (point == null) {
            return;
        }

        writePoints(bucket, organizationId, Collections.singletonList(point));
    }

    @Override
    public void writePoints(@Nonnull final String bucket,
                            @Nonnull final String organizationId,
                            @Nonnull final List<Point> points) {

        Arguments.checkNonEmpty(bucket, "bucket");
        Arguments.checkNonEmpty(organizationId, "organizationId");
        Arguments.checkNotNull(points, "points");

        Flowable<BatchWriteDataPoint> stream = Flowable.fromIterable(points).filter(Objects::nonNull)
                .map(BatchWriteDataPoint::new);

        write(bucket, organizationId, stream);
    }

    @Override
    public <M> void writeMeasurement(@Nonnull final String bucket,
                                     @Nonnull final String organizationId,
                                     @Nonnull final ChronoUnit precision,
                                     @Nullable final M measurement) {

        if (measurement == null) {
            return;
        }

        writeMeasurements(bucket, organizationId, precision, Collections.singletonList(measurement));
    }

    @Override
    public <M> void writeMeasurements(@Nonnull final String bucket,
                                      @Nonnull final String organizationId,
                                      @Nonnull final ChronoUnit precision,
                                      @Nonnull final List<M> measurements) {

        Arguments.checkNonEmpty(bucket, "bucket");
        Arguments.checkNonEmpty(organizationId, "organizationId");
        Arguments.checkNotNull(precision, "TimeUnit.precision is required");
        Arguments.checkNotNull(measurements, "records");

        Flowable<BatchWriteData> stream = Flowable
                .fromIterable(measurements)
                .map(it -> new BatchWriteDataMeasurement(it, precision));

        write(bucket, organizationId, precision, stream);
    }

    @Nonnull
    public <T extends AbstractWriteEvent> ListenerRegistration listenEvents(@Nonnull final Class<T> eventType,
                                                                            @Nonnull final EventListener<T> listener) {

        Arguments.checkNotNull(eventType, "Type of listener");
        Arguments.checkNotNull(listener, "Listener");

        Disposable subscribe = super.addEventListener(eventType).subscribe(listener::onEvent);

        return subscribe::dispose;
    }

    @Override
    public void close() {
        super.close();
    }

    @Nonnull
    Completable writeCall(final RequestBody requestBody,
                          final String organization,
                          final String bucket,
                          final String precision) {

        return platformService.writePoints(organization, bucket, precision, requestBody);
    }
}