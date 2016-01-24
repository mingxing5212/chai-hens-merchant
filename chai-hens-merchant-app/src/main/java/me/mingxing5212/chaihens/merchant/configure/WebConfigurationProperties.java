package me.mingxing5212.chaihens.merchant.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chaihens.merchant.web")
public class WebConfigurationProperties {
    private int port;
    private ThreadPool threadPool;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ThreadPool getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public static class ThreadPool {
        private int maxThreads;
        private int minThreads;
        private int idleTimeout;

        public int getIdleTimeout() {
            return idleTimeout;
        }

        public void setIdleTimeout(int idleTimeout) {
            this.idleTimeout = idleTimeout;
        }

        public int getMaxThreads() {
            return maxThreads;
        }

        public void setMaxThreads(int maxThreads) {
            this.maxThreads = maxThreads;
        }

        public int getMinThreads() {
            return minThreads;
        }

        public void setMinThreads(int minThreads) {
            this.minThreads = minThreads;
        }
    }
}
