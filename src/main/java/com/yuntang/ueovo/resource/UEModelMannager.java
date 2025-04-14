package com.yuntang.ueovo.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.yuntang.ueovo.UsagiEnergistics;

public class UEModelMannager {

    private static Path modelPath;
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public static void initResource()
    {
        initPath();
        initModel();
    }

    private static void initPath()
    {
        modelPath = Paths.get("").toAbsolutePath().resolve("config").resolve("ue_model");
        if (!Files.exists(modelPath)) {
            try {
                LOGGER.info("初始化ue模型路径: {}", modelPath);
                Files.createDirectories(modelPath);
                LOGGER.info("成功初始化ue模型路径: {}", modelPath);
            } catch (IOException e) {
                LOGGER.error("初始化ue模型路径失败: {}", e.getMessage());
            }
        } else {
            LOGGER.info("成功初始化ue模型路径: {}", modelPath);
        }
    }
    private static void initModel()
    {
        try {
            try (InputStream inputStream = UsagiEnergistics.class.getResourceAsStream("/assets/ueovo/model/uemodel.zip")) {
                if (inputStream != null) {
                    Path tempFile = Files.createTempFile("uemodel", ".zip");
                    Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
                    extractFile(tempFile.toString(), modelPath.toString());
                    Files.delete(tempFile);
                    LOGGER.info("模型资源初始化完成");
                } else {
                    LOGGER.error("找不到模型资源文件");
                }
            }
        } catch (IOException e) {
            LOGGER.error("模型资源初始化失败: {}", e.getMessage());
        }
    }
    private static void extractFile(String zipPathStr, String targetDirStr) throws IOException {
        Path zipPath = Paths.get(zipPathStr);
        Path targetDir = Paths.get(targetDirStr);
        
        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir);
        }
        
        try (FileSystem zipFs = FileSystems.newFileSystem(zipPath, (ClassLoader) null)) {
            Path root = zipFs.getPath("/");
            Files.walk(root)
                .filter(path -> !path.equals(root))
                .forEach(source -> {
                    try {
                        Path target = targetDir.resolve(root.relativize(source).toString());
                        if (Files.isDirectory(source)) {
                            Files.createDirectories(target);
                        } else {
                            Files.createDirectories(target.getParent());
                            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                        }
                    } catch (IOException e) {
                        LOGGER.error("模型文件解压失败 {}: {}", source, e.getMessage());
                    }
                });
        }
    }
}
