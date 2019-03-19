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
package org.influxdata.client.internal;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.influxdata.Arguments;
import org.influxdata.client.TasksApi;
import org.influxdata.client.domain.AddResourceMemberRequestBody;
import org.influxdata.client.domain.Label;
import org.influxdata.client.domain.LabelMapping;
import org.influxdata.client.domain.LabelResponse;
import org.influxdata.client.domain.LabelsResponse;
import org.influxdata.client.domain.LogEvent;
import org.influxdata.client.domain.Logs;
import org.influxdata.client.domain.Organization;
import org.influxdata.client.domain.ResourceMember;
import org.influxdata.client.domain.ResourceMembers;
import org.influxdata.client.domain.ResourceOwner;
import org.influxdata.client.domain.ResourceOwners;
import org.influxdata.client.domain.Run;
import org.influxdata.client.domain.RunManually;
import org.influxdata.client.domain.Runs;
import org.influxdata.client.domain.Task;
import org.influxdata.client.domain.TaskCreateRequest;
import org.influxdata.client.domain.TaskUpdateRequest;
import org.influxdata.client.domain.Tasks;
import org.influxdata.client.domain.User;
import org.influxdata.client.service.TasksService;
import org.influxdata.exceptions.NotFoundException;

import com.google.gson.Gson;
import retrofit2.Call;

/**
 * @author Jakub Bednar (bednar@github) (11/09/2018 07:59)
 */
final class TasksApiImpl extends AbstractInfluxDBRestClient implements TasksApi {

    private static final Logger LOG = Logger.getLogger(TasksApiImpl.class.getName());

    private final TasksService service;

    TasksApiImpl(@Nonnull final InfluxDBService influxDBService,
                 @Nonnull final TasksService service,
                 @Nonnull final Gson gson) {

        super(influxDBService, gson);

        this.service = service;
    }

    @Nullable
    @Override
    public Task findTaskByID(@Nonnull final String taskID) {

        Arguments.checkNonEmpty(taskID, "taskID");

        Call<Task> call = service.tasksTaskIDGet(taskID, null);

        return execute(call, NotFoundException.class);
    }

    @Nonnull
    @Override
    public List<Task> findTasks() {
        return findTasks(null, null, null);
    }

    @Nonnull
    @Override
    public List<Task> findTasksByUser(@Nonnull final User user) {

        Arguments.checkNotNull(user, "user");

        return findTasksByUserID(user.getId());
    }

    @Nonnull
    @Override
    public List<Task> findTasksByUserID(@Nullable final String userID) {

        return findTasks(null, userID, null);
    }

    @Nonnull
    @Override
    public List<Task> findTasksByOrganization(@Nonnull final Organization organization) {

        Arguments.checkNotNull(organization, "organization");

        return findTasksByOrganizationID(organization.getId());
    }

    @Nonnull
    @Override
    public List<Task> findTasksByOrganizationID(@Nullable final String orgID) {
        return findTasks(null, null, orgID);
    }

    @Nonnull
    @Override
    public List<Task> findTasks(@Nullable final String afterID,
                                @Nullable final String userID,
                                @Nullable final String orgID) {

        Call<Tasks> call = service.tasksGet(null, afterID, userID, null, orgID, null);

        Tasks tasks = execute(call);
        LOG.log(Level.FINEST, "findTasks found: {0}", tasks);

        return tasks.getTasks();
    }

    @Nonnull
    @Override
    public Task createTask(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");

        TaskCreateRequest request = new TaskCreateRequest();
        request.setFlux(task.getFlux());
        request.setOrgID(task.getOrgID());
        request.setOrg(task.getOrg());

        if (task.getStatus() != null) {
            request.setStatus(TaskCreateRequest.StatusEnum.fromValue(task.getStatus().getValue()));
        }

        return createTask(request);
    }

    @Nonnull
    @Override
    public Task createTask(@Nonnull final TaskCreateRequest taskCreateRequest) {

        Arguments.checkNotNull(taskCreateRequest, "taskCreateRequest");

        Call<Task> call = service.tasksPost(taskCreateRequest, null);

        return execute(call);
    }

    @Nonnull
    @Override
    public Task createTaskCron(@Nonnull final String name,
                               @Nonnull final String flux,
                               @Nonnull final String cron,
                               @Nonnull final Organization organization) {

        Arguments.checkNonEmpty(name, "name of the task");
        Arguments.checkNonEmpty(flux, "Flux script to run");
        Arguments.checkNonEmpty(cron, "cron expression");
        Arguments.checkNotNull(organization, "organization");

        Task task = createTask(name, flux, null, cron, organization.getId());

        return createTask(task);
    }

    @Nonnull
    @Override
    public Task createTaskCron(@Nonnull final String name,
                               @Nonnull final String flux,
                               @Nonnull final String cron,
                               @Nonnull final String orgID) {

        Arguments.checkNonEmpty(name, "name of the task");
        Arguments.checkNonEmpty(flux, "Flux script to run");
        Arguments.checkNonEmpty(cron, "cron expression");
        Arguments.checkNonEmpty(orgID, "Organization ID");

        Task task = createTask(name, flux, null, cron, orgID);

        return createTask(task);
    }

    @Nonnull
    @Override
    public Task createTaskEvery(@Nonnull final String name,
                                @Nonnull final String flux,
                                @Nonnull final String every,
                                @Nonnull final Organization organization) {

        Arguments.checkNonEmpty(name, "name of the task");
        Arguments.checkNonEmpty(flux, "Flux script to run");
        Arguments.checkNonEmpty(every, "every");
        Arguments.checkNotNull(organization, "organization");

        Task task = createTask(name, flux, every, null, organization.getId());

        return createTask(task);
    }

    @Nonnull
    @Override
    public Task createTaskEvery(@Nonnull final String name,
                                @Nonnull final String flux,
                                @Nonnull final String every,
                                @Nonnull final String orgID) {

        Arguments.checkNonEmpty(name, "name of the task");
        Arguments.checkNonEmpty(flux, "Flux script to run");
        Arguments.checkNonEmpty(every, "every expression");
        Arguments.checkNonEmpty(orgID, "Organization ID");

        Task task = createTask(name, flux, every, null, orgID);

        return createTask(task);
    }


    @Nonnull
    @Override
    public Task updateTask(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "Task is required");
        Arguments.checkDurationNotRequired(task.getEvery(), "Task.every");

        TaskUpdateRequest taskUpdateRequest = new TaskUpdateRequest();
        taskUpdateRequest.setStatus(TaskUpdateRequest.StatusEnum.fromValue(task.getStatus().getValue()));
        taskUpdateRequest.setFlux(task.getFlux());
        taskUpdateRequest.setName(task.getName());
        taskUpdateRequest.setEvery(task.getEvery());
        taskUpdateRequest.setCron(task.getCron());
        taskUpdateRequest.setOffset(task.getOffset());

        return updateTask(task.getId(), taskUpdateRequest);
    }

    @Nonnull
    @Override
    public Task updateTask(@Nonnull final String taskID, @Nonnull final TaskUpdateRequest request) {

        Arguments.checkNotNull(request, "request");
        Arguments.checkNonEmpty(taskID, "taskID");

        Call<Task> call = service.tasksTaskIDPatch(taskID, request, null);

        return execute(call);
    }

    @Override
    public void deleteTask(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "Task is required");

        deleteTask(task.getId());
    }

    @Override
    public void deleteTask(@Nonnull final String taskID) {

        Arguments.checkNonEmpty(taskID, "taskID");

        Call<Void> call = service.tasksTaskIDDelete(taskID, null);
        execute(call);
    }

    @Nonnull
    @Override
    public Task cloneTask(@Nonnull final String taskID) {

        Arguments.checkNonEmpty(taskID, "taskID");

        Task task = findTaskByID(taskID);
        if (task == null) {
            throw new IllegalStateException("NotFound Task with ID: " + taskID);
        }

        return cloneTask(task);
    }

    @Nonnull
    @Override
    public Task cloneTask(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");

        Task cloned = new Task();
        cloned.setName(task.getName());
        cloned.setOrgID(task.getOrgID());
        cloned.setFlux(task.getFlux());
        cloned.setStatus(Task.StatusEnum.ACTIVE);

        Task created = createTask(cloned);

        getLabels(task).forEach(label -> addLabel(label, created));

        return created;
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final String taskID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");

        Call<ResourceMembers> call = service.tasksTaskIDMembersGet(taskID, null);

        ResourceMembers resourceMembers = execute(call);
        LOG.log(Level.FINEST, "findTaskMembers found: {0}", resourceMembers);

        return resourceMembers.getUsers();
    }

    @Nonnull
    @Override
    public List<ResourceMember> getMembers(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "Task");

        return getMembers(task.getId());
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final User member, @Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");
        Arguments.checkNotNull(member, "member");

        return addMember(member.getId(), task.getId());
    }

    @Nonnull
    @Override
    public ResourceMember addMember(@Nonnull final String memberID, @Nonnull final String taskID) {

        Arguments.checkNonEmpty(memberID, "Member ID");
        Arguments.checkNonEmpty(taskID, "Task.ID");

        AddResourceMemberRequestBody user = new AddResourceMemberRequestBody();
        user.setId(memberID);

        Call<ResourceMember> call = service.tasksTaskIDMembersPost(taskID, user, null);

        return execute(call);
    }

    @Override
    public void deleteMember(@Nonnull final User member, @Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");
        Arguments.checkNotNull(member, "member");

        deleteMember(member.getId(), task.getId());
    }

    @Override
    public void deleteMember(@Nonnull final String memberID, @Nonnull final String taskID) {

        Arguments.checkNonEmpty(memberID, "Member ID");
        Arguments.checkNonEmpty(taskID, "Task.ID");

        Call<Void> call = service.tasksTaskIDMembersUserIDDelete(memberID, taskID, null);
        execute(call);
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final String taskID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");

        Call<ResourceOwners> call = service.tasksTaskIDOwnersGet(taskID, null);

        ResourceOwners resourceMembers = execute(call);
        LOG.log(Level.FINEST, "findTaskMembers found: {0}", resourceMembers);

        return resourceMembers.getUsers();
    }

    @Nonnull
    @Override
    public List<ResourceOwner> getOwners(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");

        return getOwners(task.getId());
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final User owner, @Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");
        Arguments.checkNotNull(owner, "owner");

        return addOwner(owner.getId(), task.getId());
    }

    @Nonnull
    @Override
    public ResourceOwner addOwner(@Nonnull final String ownerID, @Nonnull final String taskID) {

        Arguments.checkNonEmpty(ownerID, "Owner ID");
        Arguments.checkNonEmpty(taskID, "Task.ID");

        AddResourceMemberRequestBody user = new AddResourceMemberRequestBody();
        user.setId(ownerID);

        Call<ResourceOwner> call = service.tasksTaskIDOwnersPost(taskID, user, null);

        return execute(call);
    }

    @Override
    public void deleteOwner(@Nonnull final User owner, @Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");
        Arguments.checkNotNull(owner, "owner");

        deleteOwner(owner.getId(), task.getId());
    }

    @Override
    public void deleteOwner(@Nonnull final String ownerID, @Nonnull final String taskID) {

        Arguments.checkNonEmpty(ownerID, "Owner ID");
        Arguments.checkNonEmpty(taskID, "Task.ID");

        Call<Void> call = service.tasksTaskIDOwnersUserIDDelete(ownerID, taskID, null);
        execute(call);
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");

        return getRuns(task, null, null, null);
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final Task task,
                             @Nullable final OffsetDateTime afterTime,
                             @Nullable final OffsetDateTime beforeTime,
                             @Nullable final Integer limit) {

        Arguments.checkNotNull(task, "task");

        return getRuns(task.getId(), task.getOrgID(), afterTime, beforeTime, limit);
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final String taskID, @Nonnull final String orgID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");
        Arguments.checkNonEmpty(orgID, "Org.ID");

        return getRuns(taskID, orgID, null, null, null);
    }

    @Nonnull
    @Override
    public List<Run> getRuns(@Nonnull final String taskID,
                             @Nonnull final String orgID,
                             @Nullable final OffsetDateTime afterTime,
                             @Nullable final OffsetDateTime beforeTime,
                             @Nullable final Integer limit) {

        Arguments.checkNonEmpty(taskID, "Task.ID");
        Arguments.checkNonEmpty(orgID, "Org.ID");

        Call<Runs> runs = service.tasksTaskIDRunsGet(taskID, null, null, limit, afterTime, beforeTime);
        Runs execute = execute(runs, NotFoundException.class, new Runs().runs(new ArrayList<>()));

        return execute.getRuns();
    }

    @Nullable
    @Override
    public Run getRun(@Nonnull final Run run) {

        Arguments.checkNotNull(run, "run");

        return getRun(run.getTaskID(), run.getId());
    }

    @Nullable
    @Override
    public Run getRun(@Nonnull final String taskID, @Nonnull final String runID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");
        Arguments.checkNonEmpty(runID, "Run.ID");

        Call<Run> run = service.tasksTaskIDRunsRunIDGet(taskID, runID, null);

        return execute(run, NotFoundException.class);
    }

    @Nonnull
    @Override
    public List<LogEvent> getRunLogs(@Nonnull final Run run) {

        Arguments.checkNotNull(run, "run");

        return getRunLogs(run.getTaskID(), run.getId());
    }

    @Nonnull
    @Override
    public List<LogEvent> getRunLogs(@Nonnull final String taskID,
                                     @Nonnull final String runID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");
        Arguments.checkNonEmpty(runID, "Run.ID");

        Call<Logs> call = service.tasksTaskIDRunsRunIDLogsGet(taskID, runID, null);

        Logs logs = execute(call, NotFoundException.class, new Logs());

        return logs.getEvents();
    }

    @Nonnull
    @Override
    public Run runManually(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");

        return runManually(task.getId(), new RunManually());
    }

    @Nonnull
    @Override
    public Run runManually(@Nonnull final String taskId, @Nonnull final RunManually runManually) {

        Arguments.checkNonEmpty(taskId, "taskId");
        Arguments.checkNotNull(runManually, "runManually");

        Call<Run> call = service.tasksTaskIDRunsPost(taskId, runManually);

        return execute(call);
    }

    @Nullable
    @Override
    public Run retryRun(@Nonnull final Run run) {

        Arguments.checkNotNull(run, "run");

        return retryRun(run.getTaskID(), run.getId());
    }

    @Nullable
    @Override
    public Run retryRun(@Nonnull final String taskID, @Nonnull final String runID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");
        Arguments.checkNonEmpty(runID, "Run.ID");

        Call<Run> run = service.tasksTaskIDRunsRunIDRetryPost(taskID, runID, null);

        return execute(run, NotFoundException.class);
    }

    @Override
    public void cancelRun(@Nonnull final Run run) {

        Arguments.checkNotNull(run, "run");

        cancelRun(run.getTaskID(), run.getId());
    }

    @Override
    public void cancelRun(@Nonnull final String taskID, @Nonnull final String runID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");
        Arguments.checkNonEmpty(runID, "Run.ID");

        Call<Void> run = service.tasksTaskIDRunsRunIDDelete(taskID, runID, null);
        execute(run);
    }

    @Nonnull
    @Override
    public List<LogEvent> getLogs(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");

        return getLogs(task.getId());
    }

    @Nonnull
    @Override
    public List<LogEvent> getLogs(@Nonnull final String taskID) {

        Arguments.checkNonEmpty(taskID, "Task.ID");

        Call<Logs> execute = service.tasksTaskIDLogsGet(taskID, null);

        Logs logs = execute(execute, NotFoundException.class);
        if (logs == null) {
            return new ArrayList<>();
        }

        return logs.getEvents();
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final Task task) {

        Arguments.checkNotNull(task, "task");

        return getLabels(task.getId());
    }

    @Nonnull
    @Override
    public List<Label> getLabels(@Nonnull final String taskID) {

        Arguments.checkNonEmpty(taskID, "taskID");

        Call<LabelsResponse> call = service.tasksTaskIDLabelsGet(taskID, null);

        return execute(call).getLabels();
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final Label label, @Nonnull final Task task) {

        Arguments.checkNotNull(label, "label");
        Arguments.checkNotNull(task, "task");

        return addLabel(label.getId(), task.getId());
    }

    @Nonnull
    @Override
    public LabelResponse addLabel(@Nonnull final String labelID, @Nonnull final String taskID) {

        Arguments.checkNonEmpty(labelID, "labelID");
        Arguments.checkNonEmpty(taskID, "taskID");

        LabelMapping labelMapping = new LabelMapping();
        labelMapping.setLabelID(labelID);

        Call<LabelResponse> call = service.tasksTaskIDLabelsPost(taskID, labelMapping, null);

        return execute(call);
    }

    @Override
    public void deleteLabel(@Nonnull final Label label, @Nonnull final Task task) {

        Arguments.checkNotNull(label, "label");
        Arguments.checkNotNull(task, "task");

        deleteLabel(label.getId(), task.getId());
    }

    @Override
    public void deleteLabel(@Nonnull final String labelID, @Nonnull final String taskID) {

        Arguments.checkNonEmpty(labelID, "labelID");
        Arguments.checkNonEmpty(taskID, "taskID");

        Call<Void> call = service.tasksTaskIDLabelsLabelIDDelete(taskID, labelID, null);
        execute(call);
    }

    @Nonnull
    private Task createTask(@Nonnull final String name,
                            @Nonnull final String flux,
                            @Nullable final String every,
                            @Nullable final String cron,
                            @Nonnull final String orgID) {

        Arguments.checkNonEmpty(name, "name of the task");
        Arguments.checkNotNull(flux, "Flux script to run");
        Arguments.checkNonEmpty(orgID, "Organization ID");
        Arguments.checkDurationNotRequired(every, "Task.every");

        Task task = new Task();
        task.setName(name);
        task.setOrgID(orgID);
        task.setStatus(Task.StatusEnum.ACTIVE);
        task.setFlux(flux);

        String repetition = "";
        if (every != null) {
            repetition += "every: ";
            repetition += every;
        }
        if (cron != null) {
            repetition += "cron: ";
            repetition += "\"" + cron + "\"";
        }
        String fluxWithOptions = String.format("option task = {name: \"%s\", %s} \n %s", name, repetition, flux);

        task.setFlux(fluxWithOptions);

        return task;
    }
}