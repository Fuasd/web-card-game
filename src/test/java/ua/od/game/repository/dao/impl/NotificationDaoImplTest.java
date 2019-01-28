package ua.od.game.repository.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.NotificationEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.NotificationDao;

import java.util.List;

public class NotificationDaoImplTest extends DbTest{


    NotificationDao notificationDao;

    @Before
    public void init() {
        notificationDao = new NotificationDaoImpl();
    }

    @Test
    public void getAllNotificationList() {
        Assert.assertFalse(notificationDao.getAllNotificationList().isEmpty());
        List<NotificationEntity> notificationEntityList = notificationDao.getAllNotificationList ();
        for(int i = 0;i < ((List) notificationEntityList).size ();i++) {
            System.out.println (notificationEntityList.get(i).getId()+" ");
            System.out.println (notificationEntityList.get(i).getName ()+" ");
            System.out.println (notificationEntityList.get(i).getDescription ()+" ");
            System.out.println (notificationEntityList.get(i).getShowFromScratch ()+" ");
            System.out.println (notificationEntityList.get(i).getBuildingSetList ()+" ");
            System.out.println (notificationEntityList.get(i).getResourceSetList ()+" ");
            System.out.println (notificationEntityList.get(i).getUpgradeSetList ()+" ");
        }


    }

}
