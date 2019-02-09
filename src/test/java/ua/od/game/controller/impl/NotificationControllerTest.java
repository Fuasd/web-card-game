package ua.od.game.controller.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.controller.ControllerTest;
import ua.od.game.controller.NotificationController;

import java.io.IOException;

public class NotificationControllerTest extends ControllerTest {

    NotificationControllerImpl notificationController;

    @Before
    public void init() { notificationController = new NotificationControllerImpl();}

    @Test
    public void getAllNotificationListTest() throws IOException {

    }
}
