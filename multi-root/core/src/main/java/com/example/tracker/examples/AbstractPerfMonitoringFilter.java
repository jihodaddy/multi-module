package com.example.tracker.examples;

import com.example.tracker.MonitoredCall;
import com.example.tracker.TrackerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * This is an example of simple filter that allows to monitor servlet performance.
 * It allows to filter specific requests (possibly by URI or other parameters).
 *
 * @author Dima Frid
 */
public abstract class AbstractPerfMonitoringFilter implements Filter {

    @Override public void init(FilterConfig filterConfig) throws ServletException { }

    @Override public void destroy() { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (monitoredRequest(request)) {
            MonitoredCall call = new MonitoredCall(getClass().getSimpleName(), "doFilter", composeMonitoredCallArgs(request));
            TrackerFactory.getTracker(getTrackerName()).registerCall(call);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            TrackerFactory.getTracker(getTrackerName()).deregisterCall();
        }
    }

    protected String getTrackerName() {
        return TrackerFactory.DEFAULT_TRACKER_NAME;
    }

    /**
     * Implement this method to compose descriptors of monitored request
     *
     * @param request web request
     * @return monitored call arguments
     */
    protected abstract Object[] composeMonitoredCallArgs(ServletRequest request);

    /**
     * Allows to determine whether a web request should be monitored
     *
     * @param request web request
     * @return whether request is to be monitored or not
     */
    protected abstract boolean monitoredRequest(ServletRequest request);
}
