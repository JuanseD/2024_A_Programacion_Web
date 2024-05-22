package com.example.segundo_parcial.Controller;

import com.example.segundo_parcial.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.segundo_parcial.repositories.NotificationRepository;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/allnotifications")
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @GetMapping("/searchnotification/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));
    }

    @PostMapping("/createnotification")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }

    @PutMapping("/updatenotification/{id}")
    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification notificationDetails) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));

        notification.setTitle(notificationDetails.getTitle());
        notification.setMessage(notificationDetails.getMessage());
        return notificationRepository.save(notification);
    }

    @DeleteMapping("/deletenotification/{id}")
    public void deleteNotification(@PathVariable Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));

        notificationRepository.delete(notification);
    }
}

