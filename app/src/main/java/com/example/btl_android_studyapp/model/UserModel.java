package com.example.btl_android_studyapp.model;

public class UserModel {
    private String access_token;
    private String token_type;
    private int expires_in;
    private String refresh_token;
    private String userName;
    private String id;
    private String logtime;
    private String code;
    private String result;
    private String passtype;
    private String name;
    private String principal;
    private String idpc;
    private String roles;
    private String wcf;
    private String expires;
    private String issued;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPasstype() {
        return passtype;
    }

    public void setPasstype(String passtype) {
        this.passtype = passtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getIdpc() {
        return idpc;
    }

    public void setIdpc(String idpc) {
        this.idpc = idpc;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getWcf() {
        return wcf;
    }

    public void setWcf(String wcf) {
        this.wcf = wcf;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public UserModel(String access_token, String token_type, int expires_in, String refresh_token, String userName, String id, String logtime, String code, String result, String passtype, String name, String principal, String idpc, String roles, String wcf, String expires, String issued) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
        this.userName = userName;
        this.id = id;
        this.logtime = logtime;
        this.code = code;
        this.result = result;
        this.passtype = passtype;
        this.name = name;
        this.principal = principal;
        this.idpc = idpc;
        this.roles = roles;
        this.wcf = wcf;
        this.expires = expires;
        this.issued = issued;
    }
}
