package org.sid.integration.repository;

import org.apache.logging.log4j.Logger;
import org.sid.filters.QueryParameters;

import java.util.Arrays;
import java.util.List;

public abstract class IntegrationTest {

    protected int from = 0;
    protected int size = 10;

    protected abstract Logger getLogger();

    protected QueryParameters getQueryParameters(boolean paginate) {
        QueryParameters queryParameters = QueryParameters.builder()
                .build();
        if (paginate) {
            queryParameters.setFrom(from);
            queryParameters.setSize(size);
        }
        return queryParameters;
    }

    protected void logList(List list) {
        getLogger().info(Arrays.toString(list.toArray()));
    }

    protected void logTestName(String testName) {
        getLogger().info("######################################" + testName + "######################################");
    }
}
