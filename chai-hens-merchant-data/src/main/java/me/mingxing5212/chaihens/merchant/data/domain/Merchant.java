package me.mingxing5212.chaihens.merchant.data.domain;

/**
 * Merchant
 *
 * @author Mingxing Li
 * @date 23/1/16
 */
public class Merchant {
    private Long id;
    private String name;
    private String appId;
    private String secretKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
