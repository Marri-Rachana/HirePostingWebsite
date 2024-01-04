package com.Rachana.HirePostingWebsite.Repository;

import com.Rachana.HirePostingWebsite.Model.PostingProfile;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepository{
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;
    @Override
    public List<PostingProfile> findByText(String text) {
        final List<PostingProfile> postList = new ArrayList<>();

        MongoDatabase database = client.getDatabase("PostHiringWebsite");
        MongoCollection<Document> collection = database.getCollection("PostingProfile");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("Skills", "desc", "Profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 3L)));

        result.forEach(document -> postList.add(converter.read(PostingProfile.class,document)));
        return postList;
    }
}
