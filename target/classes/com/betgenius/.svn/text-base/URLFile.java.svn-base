package com.betgenius;


import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public final class URLFile extends File {

    private final URL fileUrl;

    private final File localFile;

    public URLFile(URL fileUrl, File localFile) throws IOException {
        super(localFile.getPath());
        this.localFile = localFile;
        this.fileUrl = fileUrl;
        OutputStream outputStream = new FileOutputStream(localFile);
        IOUtils.copy(this.fileUrl.openStream(), outputStream);
        outputStream.close();
        this.deleteOnExit();
    }

}
