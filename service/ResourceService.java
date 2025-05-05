package service;

import entity.Resource;
import repository.ResourceRepository;

import java.util.List;

public class ResourceService {
    private ResourceRepository resourceRepo;

    public ResourceService(ResourceRepository resourceRepo) {
        this.resourceRepo = resourceRepo;
    }

    public void addResource(Resource resource) {
        resourceRepo.addResource(resource);
    }

    public void updateResource(Resource resource) {
        resourceRepo.updateResource(resource);
    }

    public void deleteResource(String id) {
        resourceRepo.deleteResource(id);
    }

    public List<Resource> getAllResources() {
        return resourceRepo.getAllResources();
    }

    public Resource getResourceById(String id) {
        return resourceRepo.getResourceById(id);
    }
}
