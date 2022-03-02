package bmg;

import com.dansoftware.boomega.gui.theme.DarkTheme;
import com.dansoftware.boomega.gui.theme.Theme;
import com.dansoftware.boomega.plugin.api.PluginAuthor;
import com.dansoftware.boomega.plugin.api.ThemePlugin;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DarculaThemePlugin implements ThemePlugin {
    @NotNull
    @Override
    public PluginAuthor getAuthor() {
        return new PluginAuthor("","","");
    }

    @Nullable
    @Override
    public String getDescription() {
        return "null";
    }

    @Nullable
    @Override
    public Image getIcon() {
        return null;
    }

    @NotNull
    @Override
    public String getName() {
        return "Darcula Theme plugin";
    }

    @NotNull
    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() {
        System.out.println("Darcula theme plugin initialized!!!!!!!!!");
    }

    @NotNull
    @Override
    public Theme getTheme() {
        return new DraculaTheme();
    }
}
