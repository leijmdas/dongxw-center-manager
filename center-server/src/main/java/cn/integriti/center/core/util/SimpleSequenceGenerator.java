package cn.integriti.center.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.zip.CRC32;
/**
 * 
 * @className: SimpleSequenceGenerator  
 * @description: TODO 
 * @author Administrator  | www.integriti.cn
 * @date 2018年6月13日  
 *
 */
public class SimpleSequenceGenerator {
	
	private SimpleSequenceGenerator() {}
	
    public static String generate(String prefix) {
        SimpleDateFormat df = new SimpleDateFormat("MMdd");
        return prefix + df.format(new Date()) + getRandomSeq();
    }

    public static String getRandomSeq() {
        long val = getCRC32Value(UUID.randomUUID().toString().replaceAll("-", ""));
        String tmp = Long.toString(val, 30).toUpperCase();
        return tmp.replaceAll("I", "X").replaceAll("O", "Y");
    }

    public static long getCRC32Value(String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());

        return crc32.getValue();
    }
}
