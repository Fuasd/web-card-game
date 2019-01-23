package ua.od.game.repository.dao.impl;

import org.glassfish.jersey.process.internal.Stages;
import ua.od.game.model.BuildingSetEntity;
import ua.od.game.model.NotificationEntity;
import ua.od.game.model.ResourceSetEntity;
import ua.od.game.model.UpgradeSetEntity;
import ua.od.game.repository.dao.NotificationDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {
    private final String GET_NOTIFICATION_LIST_QUERY = "SELECT n.id, n.name, n.description, n.show_from_scratch, n.resource_set_id, n.upgrade_set_id, n.building_set_id, rs.id, rs.resource_id, rs.amount, bs.id, bs.building_id, bs.amount, us.id , us.upgrade_id, us.amount FROM Notification n INNER JOIN Resource_Set rs on n.resource_set_id = rs.id INNER JOIN Upgrade_Set us on n.upgrade_set_id = us.id INNER JOIN Building_Set bs on n.building_set_id = bs.id;";


    @Override
    public List<NotificationEntity> getAllNotificationList() {
        return SqlHelper.prepareStatement(GET_NOTIFICATION_LIST_QUERY, statementForNotificationList -> {
            ResultSet notificationResultSet = statementForNotificationList.executeQuery();
            List<NotificationEntity> notifications = new LinkedList<>();
            while (notificationResultSet.next()) {
                notifications.add(new NotificationEntity() {{
                    setId(notificationResultSet.getInt("id"));
                    setName(notificationResultSet.getString("name"));
                    setDescription(notificationResultSet.getString("description"));
                    setShowFromScratch(notificationResultSet.getInt("show_from_scratch"));
                    setResourceSetList(fetchResourceSetEntities(notificationResultSet));
                    setBuildingSetList(fetchBuildingSetEntities(notificationResultSet));
                    setUpgradeSetList(fetchUpgradeSetEntities(notificationResultSet));
                }});
            }
            return notifications;
        });

    }

    private List<BuildingSetEntity> fetchBuildingSetEntities(ResultSet resultSet) throws SQLException {
        List<BuildingSetEntity> buildingSetEntities = new ArrayList<> ();
        buildingSetEntities.add(new BuildingSetEntity() {{
            setId(resultSet.getInt("id"));
            setBuildingId(resultSet.getInt("building_id"));
            setAmount(resultSet.getFloat("amount"));
        }});
        return buildingSetEntities;
    }

    private List<ResourceSetEntity> fetchResourceSetEntities(ResultSet resultSet) throws SQLException {
        List<ResourceSetEntity> resourceSetEntities = new ArrayList<> ();
        resourceSetEntities.add(new ResourceSetEntity() {{
            setId(resultSet.getInt("id"));
            setResourceId(resultSet.getInt("resource_id"));
            setAmount(resultSet.getFloat("amount"));
        }});
        return resourceSetEntities;
    }

    private List<UpgradeSetEntity> fetchUpgradeSetEntities(ResultSet resultSet) throws SQLException {
        List<UpgradeSetEntity> upgradeSetEntities = new ArrayList<> ();
        upgradeSetEntities.add(new UpgradeSetEntity() {{
            setId(resultSet.getInt("id"));
            setUpgradeId(resultSet.getInt("upgrade_id"));
            setAmount(resultSet.getFloat("amount"));
        }});

        return upgradeSetEntities;
    }
}
