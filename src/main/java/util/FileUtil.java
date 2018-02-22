package util;

import java.io.*;

public class FileUtil {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + File.separator +fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 用于输入输出流间的数据拷贝
     * @param out 输出流
     * @param in 输入流
     * @throws IOException
     */
    public static void streamCopy(OutputStream out, InputStream in) throws IOException {
        byte[] temp = new byte[1024];
        int length;
        while ((length = in.read(temp)) != -1) {
            out.write(temp, 0, length);
        }
        out.flush();
    }



}
