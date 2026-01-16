package net.byteflux.libby;

import com.hypixel.hytale.logger.HytaleLogger;
import net.byteflux.libby.logging.LogLevel;
import net.byteflux.libby.logging.adapters.LogAdapter;

import java.util.logging.Level;

import static java.util.Objects.requireNonNull;

/**
 * Logging adapter that logs to a Hytale logger.
 */
public class HytaleLogAdapter implements LogAdapter {
    /**
     * Hytale logger
     */
    private final HytaleLogger logger;

    /**
     * Creates a new Hytale log adapter that logs to a {@link HytaleLogger}.
     *
     * @param logger the Hytale logger to wrap
     */
    public HytaleLogAdapter(HytaleLogger logger) {
        this.logger = requireNonNull(logger, "logger");
    }

    /**
     * Logs a message with the provided level to the Hytale logger.
     *
     * @param level   message severity level
     * @param message the message to log
     */
    @Override
    public void log(LogLevel level, String message) {
        switch (requireNonNull(level, "level")) {
            case DEBUG:
                logger.at(Level.CONFIG).log(message);
                break;
            case INFO:
                logger.at(Level.INFO).log(message);
                break;
            case WARN:
                logger.at(Level.WARNING).log(message);
                break;
            case ERROR:
                logger.at(Level.SEVERE).log(message);
                break;
        }
    }

    /**
     * Logs a message and stack trace with the provided level to the Hytale
     * logger.
     *
     * @param level     message severity level
     * @param message   the message to log
     * @param throwable the throwable to print
     */
    @Override
    public void log(LogLevel level, String message, Throwable throwable) {
        switch (requireNonNull(level, "level")) {
            case DEBUG:
                logger.at(Level.CONFIG).log(message, throwable);
                break;
            case INFO:
                logger.at(Level.INFO).log(message, throwable);
                break;
            case WARN:
                logger.at(Level.WARNING).log(message, throwable);
                break;
            case ERROR:
                logger.at(Level.SEVERE).log(message, throwable);
                break;
        }
    }
}
