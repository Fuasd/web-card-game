package ua.od.game.repository.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.NotificationDao;

public class NotificationDaoImplTest extends DbTest{


    NotificationDao notificationDao;

    @Before
    public void init() {
        notificationDao = new NotificationDaoImpl();
    }

    @Test
    public void getAllNotificationList() {
        Assert.assertFalse(notificationDao.getAllNotificationList().isEmpty());
        System.out.println(notificationDao.getAllNotificationList());
    }

}
