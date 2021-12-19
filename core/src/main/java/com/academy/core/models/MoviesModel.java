package com.academy.core.models;

import java.util.*;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;


@Model(adaptables=SlingHttpServletRequest.class)
public class MoviesModel {
    private static final Logger LOG = LoggerFactory.getLogger(MoviesModel.class);

    List<Map<String, String>> list = new ArrayList<>();

    public List<Map<String, String>>  getMovies() {
        return this.list;
    }

    @PostConstruct
    protected void populateMovies() {
        Map<String, String> item = new HashMap<String, String>();

        item.put("name", "Bad Boys for Life");
        item.put("creationDate", "2002/01/01");
        list.add(item);

        item.put("name", "Bad Boys for Life");
        item.put("creationDate", "2002/01/01");
        list.add(item);

        item.put("name", "Bad Boys for Life");
        item.put("creationDate", "2002/01/01");
        list.add(item);
    }
}