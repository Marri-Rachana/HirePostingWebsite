package com.Rachana.HirePostingWebsite.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "PostingProfile")
public class PostingProfile {

    private String Profile;
    private String desc;
    private int exp;
    private String Skills[];

    public PostingProfile() {
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        this.Profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getSkills() {
        return Skills;
    }

    public void setSkills(String[] skills) {
        this.Skills = skills;
    }

    @Override
    public String toString() {
        return "PostingProfile{" +
                "profile='" + Profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", skills=" + Arrays.toString(Skills) +
                '}';
    }
}
