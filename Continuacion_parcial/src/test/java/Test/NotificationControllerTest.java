package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.segundo_parcial.Controller.NotificationController;
import com.example.segundo_parcial.model.Notification;
import com.example.segundo_parcial.repositories.NotificationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class NotificationControllerTest {

    @Mock
    private NotificationRepository mockNotificationRepository;

    @InjectMocks
    private NotificationController notificationController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification());
        notifications.add(new Notification());
        when(mockNotificationRepository.findAll()).thenReturn(notifications);

        List<Notification> result = notificationController.getAllNotifications();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetNotificationById_WithValidId() {
        Long notificationId = 1L;
        Notification notification = new Notification();
        when(mockNotificationRepository.findById(notificationId)).thenReturn(Optional.of(notification));

        Notification result = notificationController.getNotificationById(notificationId);

        assertEquals(notification, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetNotificationById_WithInvalidId() {
        Long notificationId = 1L;
        when(mockNotificationRepository.findById(notificationId)).thenReturn(Optional.empty());

        notificationController.getNotificationById(notificationId);
    }

    @Test
    public void testCreateNotification() {
        Notification notificationToCreate = new Notification();
        notificationToCreate.setTitle("Title1");
        notificationToCreate.setMessage("Message1");
        when(mockNotificationRepository.save(notificationToCreate)).thenReturn(notificationToCreate);

        Notification result = notificationController.createNotification(notificationToCreate);

        assertEquals(notificationToCreate, result);
    }

    @Test
    public void testUpdateNotification() {
        Long notificationId = 1L;
        Notification existingNotification = new Notification();
        existingNotification.setNotificationId(notificationId);
        existingNotification.setTitle("Title1");
        existingNotification.setMessage("Message1");
        Notification updatedNotificationDetails = new Notification();
        updatedNotificationDetails.setTitle("UpdatedTitle");
        updatedNotificationDetails.setMessage("UpdatedMessage");
        when(mockNotificationRepository.findById(notificationId)).thenReturn(Optional.of(existingNotification));
        when(mockNotificationRepository.save(any(Notification.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Notification result = notificationController.updateNotification(notificationId, updatedNotificationDetails);

        assertEquals(updatedNotificationDetails.getTitle(), result.getTitle());
        assertEquals(updatedNotificationDetails.getMessage(), result.getMessage());
    }

    @Test
    public void testDeleteNotification() {
        Long notificationId = 1L;
        Notification existingNotification = new Notification();
        existingNotification.setNotificationId(notificationId);
        existingNotification.setTitle("Title1");
        existingNotification.setMessage("Message1");
        when(mockNotificationRepository.findById(notificationId)).thenReturn(Optional.of(existingNotification));

        notificationController.deleteNotification(notificationId);

        verify(mockNotificationRepository, times(1)).delete(existingNotification);
    }
}

