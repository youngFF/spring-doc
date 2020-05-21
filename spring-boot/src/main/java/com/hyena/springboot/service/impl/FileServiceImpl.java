package com.hyena.springboot.service.impl;

import com.hyena.springboot.service.FileService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;

@Service
@Log4j
public class FileServiceImpl implements FileService {


    @Override
    public int splitFile(File fileName, int blockNum) {
        int block = -1;
        if (fileName == null) {
            throw new NullPointerException("file can not be null");
        }
        if (blockNum <= 0) {
            throw new RuntimeException("blockNum can't be negative");
        }
        try {
            if (!fileName.exists()) {
                throw new FileNotFoundException("file don't exist");
            }
            // split only-if-only fileName is file
            if (fileName.isFile()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
                // get file length
                long fileLength = fileName.length();
                log.info(fileName + " length: " + fileLength);
                int blockSize  = BigDecimal.valueOf(Math.ceil(fileLength / blockNum)).intValue();
                log.info("block size is : " + blockSize);

                ByteBuffer byteBuffer = ByteBuffer.allocate(blockSize);

                OutputStream outputStream = null;

                for (int i = 0; i < blockNum; i++) {
                    String splitFileName = fileName+"_block_" + i;
                    int read = randomAccessFile.read(byteBuffer.array());


                    if (read != -1) {
                    outputStream = new BufferedOutputStream(new FileOutputStream(splitFileName));
                        outputStream.write(byteBuffer.array());
                        outputStream.flush();
                        byteBuffer.clear();
                    }
                }

                block = blockNum;
            }
        }
        catch (Exception e) {

        }

        return block;
    }

}
