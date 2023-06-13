/** public final class Files (extends Object):该类只包含对文件，目录或其他类型文件进行操作的静态方法。
 * 方法：
 * static long	copy(Path source, OutputStream out)：将文件中的所有字节复制到输出流。
 * static Path	copy(Path source, Path target, CopyOption... options)：将文件复制到目标文件。
* */
package com.nuist.io.Files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilesTest {
    public static void main(String[] args) throws IOException {
//      复制文件
        Files.copy(Paths.get("sequenceFile.java"),
                Paths.get("copySequence.java"));

//       写数据write
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("java");
        arrayList.add("python");
        arrayList.add("hadoop");
        Files.write(Paths.get("hello.txt"), arrayList, Charset.forName("GBK"));

    }
}
