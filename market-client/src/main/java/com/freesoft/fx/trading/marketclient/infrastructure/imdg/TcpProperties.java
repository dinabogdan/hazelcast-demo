package com.freesoft.fx.trading.marketclient.infrastructure.imdg;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "tcp")
public class TcpProperties {
    private boolean enabled;
    private List<String> members;

    public TcpProperties() {

    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
