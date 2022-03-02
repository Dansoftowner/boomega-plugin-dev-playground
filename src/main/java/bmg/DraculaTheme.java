package bmg;

import com.dansoftware.boomega.gui.theme.Theme;
import com.github.mouse0w0.darculafx.DarculaFX;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.jetbrains.annotations.NotNull;

public class DraculaTheme extends Theme {
    @NotNull
    @Override
    public String getName() {
        return "Dracula";
    }

    @Override
    public void apply(@NotNull Parent parent) {
        DarculaFX.applyDarculaStyle(parent);
    }

    @Override
    public void apply(@NotNull Scene scene) {
        DarculaFX.applyDarculaStyle(scene);
    }

    @Override
    public void deApply(@NotNull Parent parent) {
        parent.getStylesheets().remove(DarculaFX.DARCULA_STYLE_URL);
    }

    @Override
    public void deApply(@NotNull Scene scene) {
        scene.getStylesheets().remove(DarculaFX.DARCULA_STYLE_URL);
    }
}
