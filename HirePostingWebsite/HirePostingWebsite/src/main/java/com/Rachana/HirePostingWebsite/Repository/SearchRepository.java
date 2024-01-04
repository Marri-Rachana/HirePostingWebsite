package com.Rachana.HirePostingWebsite.Repository;

import com.Rachana.HirePostingWebsite.Model.PostingProfile;

import java.util.List;

public interface SearchRepository {
    List<PostingProfile> findByText(String text);
}
