/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Hunar Roop (KingGoesGaming) Kahlon
 * Copyright (c) Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ca.kinggoesgaming.sponge.spongevanillacontrol;

import ca.kinggoesgaming.sponge.spongevanillacontrol.managers.config.ConfigManager;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.*;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;

/**
 * Main class of Sponge Vanilla Control plugin
 */
@Plugin(id = PluginDescription.ID,
        name = PluginDescription.NAME,
        version = PluginDescription.VERSION)
public class SpongeVanillaControl {

    private static SpongeVanillaControl instance;

    @Inject
    private Logger logger;

    public static SpongeVanillaControl getInstance() {
        return instance;
    }

    @Listener
    public void onPreInitialization(GamePreInitializationEvent event) {
        instance = this;
        setupConfigs();
    }

    @Listener
    public void onInitialization(GameInitializationEvent event) {
    }

    @Listener
    public void onPostInitialization(GamePostInitializationEvent event) {

    }

    @Listener
    public void onStartedServer(GameStartedServerEvent event) {

    }

    @Listener
    public void onStoppedServer(GameStoppedServerEvent event) {

    }

    private void setupConfigs() {
        File configDir = new File("config/" + PluginDescription.ID + "/");

        if(!configDir.exists()) {
            configDir.mkdirs();
        }

        ConfigManager.getInstance().setup();
    }

    public Logger getLogger() {
        return logger;
    }

}
