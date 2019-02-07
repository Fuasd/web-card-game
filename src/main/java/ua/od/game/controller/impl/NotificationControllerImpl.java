package ua.od.game.controller.impl;

import ua.od.game.controller.NotificationController;
import ua.od.game.dto.NotificationDto;
import ua.od.game.service.NotificationService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("notification")
public class NotificationControllerImpl implements NotificationController {

    @Inject
    public NotificationService notificationService;

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<NotificationDto> getAllNotificationList() {
        List<NotificationDto> notificationDtos = notificationService.getAllNotificationList();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, notificationDtos.toString());
        return notificationDtos;
    }
}
