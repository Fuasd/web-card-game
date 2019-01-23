package ua.od.game.model;

import java.util.List;

public class NotificationEntity {
    private Integer id;
    private String name;
    private String description;
    private Integer showFromScratch;
    private List<ResourceSetEntity> resourceSetList;
    private List<BuildingSetEntity> buildingSetList;
    private List<UpgradeSetEntity> upgradeSetList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShowFromScratch() {
        return showFromScratch;
    }

    public void setShowFromScratch(Integer showFromScratch) {
        this.showFromScratch = showFromScratch;
    }

    public List<ResourceSetEntity> getResourceSetList() {
        return resourceSetList;
    }

    public void setResourceSetList(List<ResourceSetEntity> resourceSetList) {
        this.resourceSetList = resourceSetList;
    }

    public List<BuildingSetEntity> getBuildingSetList() {
        return buildingSetList;
    }

    public void setBuildingSetList(List<BuildingSetEntity> buildingSetList) {
        this.buildingSetList = buildingSetList;
    }

    public List<UpgradeSetEntity> getUpgradeSetList() {
        return upgradeSetList;
    }

    public void setUpgradeSetList(List<UpgradeSetEntity> upgradeSetList) {
        this.upgradeSetList = upgradeSetList;
    }

    @Override
    public String toString() {
        return "NotificationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", showFromScratch=" + showFromScratch +
                ", resourceSetList=" + resourceSetList +
                ", buildingSetList=" + buildingSetList +
                ", upgradeSetList=" + upgradeSetList +
                '}';
    }
}
