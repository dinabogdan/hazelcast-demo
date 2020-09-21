package com.freesoft.fx.trading.processingunit.infrastructure.imdg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties(prefix = "tcp")
public class TcpProperties {

    private Boolean enabled;
    private List<String> members;

    public TcpProperties(Boolean enabled, List<String> members) {
        this.enabled = enabled;
        this.members = members;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
