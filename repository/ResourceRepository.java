package repository;

import entity.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceRepository {

    private Map<String, Resource> resourceMap;

    public ResourceRepository() {
        this.resourceMap = new HashMap<>();
    }

    public void addResource(Resource resource) {
        resourceMap.put(resource.getId(), resource);
    }

    public void updateResource(Resource resource) {
        if (resourceMap.containsKey(resource.getId())) {
            resourceMap.put(resource.getId(), resource);
        }
    }

    public void deleteResource(String id) {
        resourceMap.remove(id);
    }

    public List<Resource> getAllResources() {
        return new ArrayList<>(resourceMap.values());
    }

    public Resource getResourceById(String id) {
        return resourceMap.get(id);
    }
}
