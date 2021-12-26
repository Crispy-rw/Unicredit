package com.academy.core.models;

import java.util.*;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class SliderModel {
    private static final Logger LOG = LoggerFactory.getLogger(SliderModel.class);

    @SlingObject
    private Resource currentResource;

    public List<Map<String, String>> getSlides() {
        List<Map<String, String>> slides = new ArrayList<>();
        try {
            Resource slidesList = currentResource.getChild("slidesList");
            if (slidesList == null) {
                return Collections.emptyList();
            }
            if (slidesList != null) {
                for (Resource slide : slidesList.getChildren()) {
                    Map<String, String> slideMap = new HashMap<String, String>();
                    slideMap.put("caption", slide.getValueMap().get("caption", String.class));
                    slideMap.put("imageLocation", slide.getValueMap().get("fileReference", String.class));
                    slides.add(slideMap);
               }
            }
        } catch (Exception e) {
            LOG.error("\n ERROR while getting Slide Details Multifield {} ", e.getMessage());
        }
        // LOG.error("\n Images Uploaded Successfully!");
        return slides;
    }
}