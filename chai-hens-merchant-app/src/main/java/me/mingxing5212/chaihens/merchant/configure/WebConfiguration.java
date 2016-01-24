package me.mingxing5212.chaihens.merchant.configure;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Slf4jRequestLog;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.TimeZone;

@Configuration
@EnableConfigurationProperties(WebConfigurationProperties.class)
public class WebConfiguration {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private WebConfigurationProperties properties;

    @Bean
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.setThrowExceptionIfNoHandlerFound(true);
        return servlet;
    }

    @Bean
    public JettyServerCustomizer jettyServerCustomizer() {
        return new JettyServerCustomizer() {
            @Override
            public void customize(Server server) {
                // Tweak the connection config used by Jetty to handle incoming HTTP connections
                final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
                WebConfigurationProperties.ThreadPool config = properties.getThreadPool();
                threadPool.setMaxThreads(config.getMaxThreads());
                threadPool.setMinThreads(config.getMinThreads());
                threadPool.setIdleTimeout(config.getIdleTimeout());
                requestLogSetup(server);
            }
        };
    }

    @SuppressWarnings("unused")
    private void requestLogSetup(Server server) {
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(server.getHandlers());
        Slf4jRequestLog requestLog = new Slf4jRequestLog();
        requestLog.setExtended(true);
        requestLog.setLogCookies(false);
        requestLog.setLogTimeZone(TimeZone.getDefault().getID());
        RequestLogHandler requestLogHandler = new RequestLogHandler();
        requestLogHandler.setRequestLog(requestLog);
        handlers.addHandler(requestLogHandler);
        server.setHandler(handlers);
    }

    @Bean
    public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory(
            JettyServerCustomizer jettyServerCustomizer) {
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory(
                properties.getPort());
        factory.addServerCustomizers(jettyServerCustomizer);
        return factory;
    }

}
