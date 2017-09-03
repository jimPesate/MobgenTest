package com.mobGen.test.model;

import java.util.ArrayList;

public class Module {


    private boolean isSingle;
    private String name;
    private ArrayList tags;
    private String defaultLanguage;
    private ArrayList pushTemplates;
    private int customerId;
    private String createdBy;
    private String updatedBy;
    private String externalId;
    private long deletedAt;
    private String deletedBy;
    private long createdAt;
    private long updatedAt;
    private String id;

    @Override
    public boolean equals(Object o) {

        if (o instanceof Module) {
            Module other = (Module) o;
            return (this.name.equals(other.name)
                    && this.id.equals(other.id));
        }

        return false;
    }

    public boolean iSingle() {
        return isSingle;
    }

    public void setIsSingle(boolean isSingle) {
        this.isSingle = isSingle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getTags() {
        return tags;
    }

    public void setTags(ArrayList tags) {
        this.tags = tags;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public ArrayList getPushTemplates() {
        return pushTemplates;
    }

    public void setPushTemplates(ArrayList pushTemplates) {
        this.pushTemplates = pushTemplates;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
