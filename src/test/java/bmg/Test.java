package bmg;

import com.dansoftware.boomega.config.CommonPreferences;
import com.dansoftware.boomega.config.Preferences;
import com.dansoftware.boomega.config.source.ConfigSource;
import com.dansoftware.boomega.config.source.InMemorySource;
import com.dansoftware.boomega.di.DIService;
import com.dansoftware.boomega.gui.app.BaseBoomegaApplication;
import com.dansoftware.boomega.gui.app.BoomegaApp;
import com.dansoftware.boomega.main.PropertiesSetup;
import com.dansoftware.boomega.plugin.api.BoomegaPlugin;
import com.dansoftware.boomega.plugin.api.PluginService;
import com.dansoftware.boomega.plugin.api.ThemePlugin;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        PropertiesSetup.setupSystemProperties();
        List<Module> modules = new LinkedList<>();
        modules.add(new AbstractModule() {
            @Override
            protected void configure() {
                bind(PluginService.class).to(DummyPluginService.class);
                bind(ConfigSource.class).to(DummyConfigSource.class);

            }
        });
        DIService.initModules(modules.toArray(Module[]::new));
        BaseBoomegaApplication.launchApp(BoomegaApp.class);
    }

    private static class DummyConfigSource extends InMemorySource {

        DummyConfigSource() {
            put(CommonPreferences.SEARCH_UPDATES, false);
        }

        @Override
        public boolean isCreated() {
            return false;
        }
    }

    private static class DummyPluginService implements PluginService {

        private BoomegaPlugin themePlugin = new DarculaThemePlugin();

        @NotNull
        @Override
        public List<BoomegaPlugin> getAll() {
            return Collections.singletonList(themePlugin);
        }

        @Override
        public int getPluginFileCount() {
            return 0;
        }

        @Override
        public void close() {
        }

        @Override
        public void load() {
        }

        @NotNull
        @Override
        public <P extends BoomegaPlugin> List<P> of(@NotNull Class<P> aClass) {
            if (aClass == ThemePlugin.class)
                return (List<P>) Collections.singletonList(themePlugin);
            return Collections.emptyList();
        }

        @NotNull
        @Override
        public List<BoomegaPlugin> pluginsOfLocation(@NotNull URL url) {
            return List.of();
        }
    }
}
