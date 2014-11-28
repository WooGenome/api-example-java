package com.nodexy.genome.session;

import java.util.Calendar;
import java.util.Date;

public class SessionToken {

    private String accessToken;
    private String tokenType;
    private String expires;
    private String refreshToken;
    private String scope;
    private Date createTime;

    public SessionToken() {

    }

    public SessionToken(String accessToken, String tokenType, String expires,
            String refreshToken, String scope) {
        super();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expires = expires;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.createTime = Calendar.getInstance().getTime();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SessionToken [accessToken=" + accessToken + ", tokenType="
                + tokenType + ", expires=" + expires + ", refreshToken="
                + refreshToken + ", scope=" + scope + ", createTime="
                + createTime + "]";
    }

}
