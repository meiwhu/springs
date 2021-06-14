package com.example.managing_transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AppRunner implements CommandLineRunner {
    private final static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookingService bookingService;

    public AppRunner(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void run(String... args) throws Exception {
        bookingService.book("Alice", "Bob", "Carol");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "First Booking should work with no problem");
        logger.info("Alice, Bob and Carol have been booked");
        try {
            bookingService.book("Chris", "Samuel");
        } catch (Exception e) {
            logger.info("v--- The following exception is expect because 'Samuel' is too big for the DB ---v");
            logger.error(e.getMessage());
        }
        for(var person : bookingService.findAllBookings()) {
            logger.info("So far, " + person + " is booked");
        }
        logger.info("You shouldn't see Chris or Samuel.");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "'Samuel', should have triggered a rollback");
        try {
            bookingService.book("Buddy", null);
        } catch (Exception e) {
            logger.info("v--- The following exception is except because null is not valid for the DB ---v");
            logger.info(e.getMessage());
        }
        for(var person : bookingService.findAllBookings()) {
            logger.info("So far, " + person + " is booked");
        }
        logger.info("You should not see Buddy or null");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "null should have triggered a rollback");
    }
}
