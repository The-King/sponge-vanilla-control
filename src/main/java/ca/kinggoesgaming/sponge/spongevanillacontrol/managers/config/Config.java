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

package ca.kinggoesgaming.sponge.spongevanillacontrol.managers.config;

import ca.kinggoesgaming.sponge.spongevanillacontrol.PluginDescription;
import ninja.leaping.configurate.ConfigurationOptions;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class Config implements Configurable {

    private Config() {}

    private static Config instance = new Config();

    private static File config = new File("config/" + PluginDescription.ID + "/config.conf");
    private static ConfigurationLoader<CommentedConfigurationNode> configManager = HoconConfigurationLoader.builder().setFile(config).build();
    private static CommentedConfigurationNode configNode = configManager.createEmptyNode(ConfigurationOptions.defaults());

    @Override
    public void load() {
        try {
            configNode = configManager.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            configManager.save(configNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setup() {
        try {

            if (!config.exists()) {
                config.createNewFile();

                setDefaultNodes();

                save();

            }

            load();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upgrade() {
        setDefaultNodes();
        save();
    }

    private void setDefaultNodes() {
        getConfig().getNode("locale").
                setComment("The locale name of the language you want to you!\n" +
                        "The lang files are located in config/" + PluginDescription.ID + "/lang/<locale>.yml").
                setValue("en-us");
    }

    @Override
    public CommentedConfigurationNode getConfig() {
        return configNode;
    }

    public static Config getInstance() {
        return instance;
    }
}
