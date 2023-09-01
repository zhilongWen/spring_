package com.at.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @create 2023-08-28
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
