package com.betgenius;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.codehaus.plexus.component.annotations.Component;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

@Component(role = ConfigOperations.class)
public class ConfigOperations {

    public String getConfigIdFromFile(File config) {
        try {
            return new ObjectMapper().readValue(config, JsonNode.class).get("id").asText();
        } catch (IOException e) {
            return null;

        }
    }

    public List<String> getConfigIdsFromFiles(List<File> files) {
        ImmutableList.Builder<String> builder = new ImmutableList.Builder<String>();
        for (File file : files) {
            String id = getConfigIdFromFile(file);
            if (id != null) {
                builder.add(id);
            }
        }
        return builder.build();
    }


}
