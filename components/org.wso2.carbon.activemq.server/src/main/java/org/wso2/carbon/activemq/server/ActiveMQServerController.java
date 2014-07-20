/*
 * Copyright 2014 Deependra Ariyadewa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.wso2.carbon.activemq.server;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.console.CommandContext;
import org.apache.activemq.console.command.Command;
import org.apache.activemq.console.command.StartCommand;
import org.apache.activemq.console.formatter.CommandShellOutputFormatter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Control the ActiveMQ Daemon :
 */
public class ActiveMQServerController {

    private static Log log = LogFactory.getLog(ActiveMQServerController.class);

    BrokerService brokerService;
    private Thread thread;

    public ActiveMQServerController() {
    }

    /**
     * Starts Activemq daemon
     */
    public void start() {
        log.info("Starting ActiveMQ");
        log.debug("Activating ActiveMQ Server");
        brokerService = new BrokerService();
        try {
            brokerService.addConnector("tcp://localhost:61616");
            brokerService.start();
        } catch (Exception e) {
            log.info("Error in broker service startup");
            e.printStackTrace();
        }
    }

    /**
     * Stops the ActiveMQ daemon
     */
    public void shutdown() {
        log.info("Shutting down ActiveMQ Server");
        log.debug("Deactivating the ActiveMQ Server");
        try {
            brokerService.stop();
        } catch (Exception e) {
            log.info("Error in broker service shutdown");
            e.printStackTrace();
        }
    }
}
