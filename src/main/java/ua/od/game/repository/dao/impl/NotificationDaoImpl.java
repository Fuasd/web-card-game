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
    private final String GET_NOTIFICATION_LIST_QUERY =
            "SELECT n.id, " + "" +
                    "n.name,\n" +"" +
                    "n.description,\n"+
                    "n.show_from_scratch,\n" +
                    "n.resource_set_id,\n" +
                    "n.upgrade_set_id,\n" +
                    "n.building_set_id,\n" +
                    "rs.resource_id,\n" +
                    "rs.amount rs_amount,\n" +
                    "bs.building_id,\n" +
                    "bs.amount bs_amount,\n" +
                    "us.upgrade_id,\n" +
                    "us.amount us_amount \n" +
                    "FROM Notification n \n" +
                    "INNER JOIN Resource_Set rs on n.resource_set_id = rs.id \n" +
                    "INNER JOIN Upgrade_Set us on n.upgrade_set_id = us.id \n" +
                    "INNER JOIN Building_Set bs on n.building_set_id = bs.id;";





    @Override
    public List<NotificationEntity> getAllNotificationList() {
        return SqlHelper.prepareStatement(GET_NOTIFICATION_LIST_QUERY, statementForNotificationList -> {
            ResultSet resultSet = statementForNotificationList.executeQuery();
            List<NotificationEntity> notifications = new LinkedList<>();
            while (resultSet.next()) {
                notifications.add(new NotificationEntity() {{
                    setId(resultSet.getInt("id"));
                    setName(resultSet.getString("name"));
                    setDescription(resultSet.getString("description"));
                    setShowFromScratch(resultSet.getInt("show_from_scratch"));
                    if (getBuildingSetList() == null)
                        setBuildingSetList(new ArrayList<>());
                    getBuildingSetList().add(new BuildingSetEntity() {{
                        setId(resultSet.getInt("building_set_id"));
                        setBuildingId(resultSet.getInt("building_id"));
                        setAmount(resultSet.getFloat("bs_amount"));
                    }});
                    if (getResourceSetList() == null)
                        setResourceSetList(new ArrayList<>());
                    getResourceSetList().add(new ResourceSetEntity() {{
                        setId(resultSet.getInt("resource_set_id"));
                        setResourceId(resultSet.getInt("resource_id"));
                        setAmount(resultSet.getFloat("rs_amount"));
                    }});
                    if (getUpgradeSetList () == null)
                        setUpgradeSetList(new ArrayList<>());
                    getUpgradeSetList().add(new UpgradeSetEntity() {{
                        setId(resultSet.getInt("upgrade_set_id"));
                        setUpgradeId(resultSet.getInt("upgrade_id"));
                        setAmount(resultSet.getFloat("us_amount"));
                    }});
                }});
            }
            return notifications;
        });

    }


}
