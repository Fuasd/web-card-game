package ua.od.game.service.impl;

import ua.od.game.dto.*;
import ua.od.game.model.BuildingSetEntity;
import ua.od.game.model.ResourceSetEntity;
import ua.od.game.model.UpgradeSetEntity;
import ua.od.game.repository.dao.NotificationDao;
import ua.od.game.service.NotificationService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    @Inject
    public NotificationDao notificationDao;

    public List<NotificationDto> getAllNotificationList() {
        List<NotificationDto> notificationDtos = new LinkedList<>();
        notificationDao.getAllNotificationList().forEach(notificationEntity -> notificationDtos.add(new NotificationDto() {{
            setId(notificationEntity.getId());
            setName(notificationEntity.getName());
            setDescription(notificationEntity.getDescription());
            setShowFromScratch(notificationEntity.getShowFromScratch());
            setUpgradeSetList(convertUpgradeSetEntity(notificationEntity.getUpgradeSetList()));
            setResourceSetList(convertResourceSetEntity(notificationEntity.getResourceSetList()));
            setBuildingSetList(convertBuildingSetEntity(notificationEntity.getBuildingSetList()));
        }}));
        return notificationDtos;
    }

    private List<UpgradeSetDto> convertUpgradeSetEntity(List<UpgradeSetEntity> upgradeSetEntities) {
        List<UpgradeSetDto> upgradeSetDtos = new LinkedList<>();
        upgradeSetEntities.forEach(upgradeSetEntity -> upgradeSetDtos.add(new UpgradeSetDto() {{
            setId(upgradeSetEntity.getId());
            setSetId(upgradeSetEntity.getSetId());
            setAmount(upgradeSetEntity.getAmount());
            setUpgradeId(upgradeSetEntity.getUpgradeId());
        }}));
        return upgradeSetDtos;
    }

    private List<ResourceSetDto> convertResourceSetEntity(List<ResourceSetEntity> resourceSetEntities) {
        List<ResourceSetDto> resourceSetDtos = new LinkedList<>();
        resourceSetEntities.forEach(resourceSetEntity -> resourceSetDtos.add(new ResourceSetDto() {{
            setId(resourceSetEntity.getId());
            setSetId(resourceSetEntity.getSetId());
            setAmount(resourceSetEntity.getAmount());
            setResourceId(resourceSetEntity.getResourceId());
        }}));
        return resourceSetDtos;
    }

    private List<BuildingSetDto> convertBuildingSetEntity(List<BuildingSetEntity> buildingSetEntities) {
        List<BuildingSetDto> buildingSetDtos = new LinkedList<>();
        buildingSetEntities.forEach(buildingSetEntity -> buildingSetDtos.add(new BuildingSetDto() {{
            setId(buildingSetEntity.getId());
            setSetId(buildingSetEntity.getSetId());
            setAmount(buildingSetEntity.getAmount());
            setBuildingId(buildingSetEntity.getBuildingId());
        }}));
        return buildingSetDtos;
    }
}

