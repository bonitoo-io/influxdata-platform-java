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

import java.util.List;
import javax.annotation.Nonnull;

import org.influxdata.Arguments;
import org.influxdata.client.VariablesApi;
import org.influxdata.client.domain.Organization;
import org.influxdata.client.domain.Variable;
import org.influxdata.client.domain.Variables;
import org.influxdata.client.service.VariablesService;
import org.influxdata.internal.AbstractRestClient;

import retrofit2.Call;

/**
 * @author Jakub Bednar (27/03/2019 09:37)
 */
final class VariablesApiImpl extends AbstractRestClient implements VariablesApi {

    private final VariablesService service;

    VariablesApiImpl(@Nonnull final VariablesService service) {

        Arguments.checkNotNull(service, "service");

        this.service = service;
    }

    @Nonnull
    @Override
    public Variable createVariable(@Nonnull final Variable variable) {

        Arguments.checkNotNull(variable, "variable");

        Call<Variable> call = service.variablesPost(variable, null);

        return execute(call);
    }

    @Nonnull
    @Override
    public Variable updateVariable(@Nonnull final Variable variable) {

        Arguments.checkNotNull(variable, "variable");

        Call<Variable> call = service.variablesVariableIDPatch(variable.getId(), variable, null);

        return execute(call);
    }

    @Override
    public void deleteVariable(@Nonnull final Variable variable) {

        Arguments.checkNotNull(variable, "variable");

        deleteVariable(variable.getId());
    }

    @Override
    public void deleteVariable(@Nonnull final String variableID) {

        Arguments.checkNonEmpty(variableID, "variableID");

        Call<Void> call = service.variablesVariableIDDelete(variableID, null);

        execute(call);
    }

    @Nonnull
    @Override
    public Variable findVariableByID(@Nonnull final String variableID) {

        Arguments.checkNonEmpty(variableID, "variableID");

        Call<Variable> call = service.variablesVariableIDGet(variableID, null);

        return execute(call);
    }

    @Nonnull
    @Override
    public List<Variable> findVariables(@Nonnull final Organization organization) {

        Arguments.checkNotNull(organization, "organization");

        return findVariables(organization.getId());
    }

    @Nonnull
    @Override
    public List<Variable> findVariables(@Nonnull final String orgID) {

        Arguments.checkNonEmpty(orgID, "orgID");

        Call<Variables> call = service.variablesGet(null, null, orgID);

        return execute(call).getVariables();
    }
}
