package com.at.springframework.core.io;

import com.at.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @create 2023-09-02
 */
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {

        InputStream is = classLoader.getResourceAsStream(path);

        if (null == is) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exists"
            );
        }

        return is;
    }
}
