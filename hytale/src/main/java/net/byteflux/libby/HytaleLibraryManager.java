package net.byteflux.libby;

import com.hypixel.hytale.server.core.plugin.PluginBase;
import net.byteflux.libby.classloader.URLClassLoaderHelper;

import java.net.URLClassLoader;
import java.nio.file.Path;

import static java.util.Objects.requireNonNull;

/**
 * A runtime dependency manager for Bukkit plugins.
 */
public class HytaleLibraryManager extends LibraryManager {
    /**
     * Plugin classpath helper
     */
    private final URLClassLoaderHelper classLoader;

    /**
     * Creates a new Hytale library manager.
     *
     * @param plugin the plugin to manage
     */
    public HytaleLibraryManager(PluginBase plugin) {
        this(plugin, "lib");
    }

    /**
     * Creates a new Hytale library manager.
     *
     * @param plugin the plugin to manage
     * @param directoryName download directory name
     */
    public HytaleLibraryManager(PluginBase plugin, String directoryName) {
        super(new HytaleLogAdapter(requireNonNull(plugin, "plugin").getLogger()), plugin.getDataDirectory(), directoryName);
        classLoader = new URLClassLoaderHelper((URLClassLoader) plugin.getClass().getClassLoader(), this);
    }

    /**
     * Adds a file to the Hytale plugin's classpath.
     *
     * @param file the file to add
     */
    @Override
    protected void addToClasspath(Path file) {
        classLoader.addToClasspath(file);
    }
}
