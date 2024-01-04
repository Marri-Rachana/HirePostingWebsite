package com.Rachana.HirePostingWebsite.Repository;

import com.Rachana.HirePostingWebsite.Model.PostingProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingProfileRepo extends MongoRepository<PostingProfile,String> {
}
