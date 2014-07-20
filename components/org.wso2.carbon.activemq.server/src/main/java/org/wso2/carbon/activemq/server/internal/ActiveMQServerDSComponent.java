package org.wso2.carbon.activemq.server.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.activemq.server.ActiveMQServerController;

/**
 * @scr.component name="org.wso2.carbon.activemq.server.component" immediate="true"
 * */

public class ActiveMQServerDSComponent {

    private static Log log = LogFactory.getLog(ActiveMQServerDSComponent.class);
    private ActiveMQServerController activeMQServerController;

    protected void activate(ComponentContext componentContext) {
        activeMQServerController = new ActiveMQServerController();
        activeMQServerController.start();
    }

    protected void deactivate(ComponentContext componentContext) {

        if (log.isDebugEnabled()) {
            log.debug("Stopping the ActiveMQ Server component");
        }
        activeMQServerController.shutdown();
    }

}






