package test;

import com.sun.media.sound.InvalidDataException;
import test.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import static test.Base64Coder.CHARSET_UTF8;

public class Test {
    private String encodeData(final String rawMessage) throws InvalidDataException {
        GZIPOutputStream gos = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(rawMessage.getBytes(CHARSET_UTF8).length);
            gos = new GZIPOutputStream(os);
            gos.write(rawMessage.getBytes(CHARSET_UTF8));
            gos.close();
            byte[] compressed = os.toByteArray();
            os.close();
            return new String(Base64Coder.encode(compressed));
        } catch (IOException exception) {
            // 格式错误，直接将数据删除
            throw new InvalidDataException(exception.getMessage());
        } finally {
            if (gos != null) {
                try {
                    gos.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }

    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    public static void main(String[] args) {
        String encodeString = "H4sIAAAAAAAAAO1UTWvjMBA9J7+ieHtsjWQ7rtNbYD8I7LLLdtldKEWo9rgZaktGkhOyS/57JX+0CaZJeizEJ/Nm3szoSfNu/49HHjOKp48MM+/67JIGUXIVT+PJ9MKGDJZgURpHNEjCJA5ISBt8XTnca5ieQzLUBkVq2jIe4XFIcogSApSECW9yuJBiXcpa70vCDIRBg6Btih1v5J130JpxkSmJ2Wv08WjjKhR4/0y1/6wEs5ANg9dG/upHbqMOnrVlX0C2BKVRCheMferTLsSrajtEfbLFycBwLByeytLXhhsnSaorJf2v8gHFLDW4tMf40Hz9tLC0h3Os81lV/UZY3aQKQDRaWGoFakcLqXcm6CcrZQZN74CSKaU0nn3pIlIPj6ibFmyFmVm46yUJaQP3ykrs8n9++vhtvpu9AHxYuEmDiJDDegy7ZrDEFPbcfVdR8ObReTfPEv5Q8vDluLf6TwpgMs81uEEvo2Rr0Lbv4G56Abmoc56aWoFyeX/ns++9AlXBTS5VOTzSCnO0qFE1tIAAs5LqkfUL8mf+uZexVsc8jl3NeymOI9kdKfYq9/omoGY5Km1Yxtc2nvNCwwuvKmrbbUv4W69bxevQj/zIu+seM8uLWi/Yjm1MojBMQjreXJwN3SYOaTixZnM1cJtJFMTx5OQ2J7c5uU3HUpCDsgy2d9Hf4kl9xeM95t252CFnish4czd+AvINcScJCQAA";
        System.out.println(new String(uncompress(Base64Coder.decode(encodeString))));
//        try {
//            String s = new Test().encodeData("[{\n" +
//                    "\t\"_track_id\": -1248769659,\n" +
//                    "\t\"time\": 1641283862031,\n" +
//                    "\t\"type\": \"track\",\n" +
//                    "\t\"distinct_id\": \"0a630fe480e1038a\",\n" +
//                    "\t\"anonymous_id\": \"0a630fe480e1038a\",\n" +
//                    "\t\"identities\": {\n" +
//                    "\t\t\"$identity_android_id\": \"0a630fe480e1038a\"\n" +
//                    "\t},\n" +
//                    "\t\"lib\": {\n" +
//                    "\t\t\"$lib_method\": \"autoTrack\",\n" +
//                    "\t\t\"$lib\": \"Android\",\n" +
//                    "\t\t\"$lib_version\": \"6.1.1\",\n" +
//                    "\t\t\"$app_version\": \"1.0\",\n" +
//                    "\t\t\"$lib_detail\": \"com.statisticspro.LoginActivity######\"\n" +
//                    "\t},\n" +
//                    "\t\"event\": \"$AppViewScreen\",\n" +
//                    "\t\"properties\": {\n" +
//                    "\t\t\"$os_version\": \"11\",\n" +
//                    "\t\t\"$model\": \"21091116AG\",\n" +
//                    "\t\t\"$os\": \"Android\",\n" +
//                    "\t\t\"$screen_width\": 1080,\n" +
//                    "\t\t\"$brand\": \"REDMI\",\n" +
//                    "\t\t\"$screen_height\": 2400,\n" +
//                    "\t\t\"$app_version\": \"1.0\",\n" +
//                    "\t\t\"$lib\": \"Android\",\n" +
//                    "\t\t\"$device_id\": \"0a630fe480e1038a\",\n" +
//                    "\t\t\"$app_name\": \"StatisticsPro\",\n" +
//                    "\t\t\"$lib_version\": \"6.1.1\",\n" +
//                    "\t\t\"$timezone_offset\": -480,\n" +
//                    "\t\t\"$app_id\": \"com.statisticspro\",\n" +
//                    "\t\t\"$manufacturer\": \"XIAOMI\",\n" +
//                    "\t\t\"platform\": \"Android\",\n" +
//                    "\t\t\"$wifi\": true,\n" +
//                    "\t\t\"$network_type\": \"WIFI\",\n" +
//                    "\t\t\"$url\": \"com.statisticspro.LoginActivity\",\n" +
//                    "\t\t\"$screen_name\": \"com.statisticspro.LoginActivity\",\n" +
//                    "\t\t\"$title\": \"StatisticsPro\",\n" +
//                    "\t\t\"$lib_method\": \"autoTrack\",\n" +
//                    "\t\t\"$is_first_day\": false,\n" +
//                    "\t\t\"$lib_plugin_version\": [\"android:3.4.4\"]\n" +
//                    "\t},\n" +
//                    "\t\"_flush_time\": 1641285433831\n" +
//                    "}, {\n" +
//                    "\t\"_track_id\": -1631356597,\n" +
//                    "\t\"time\": 1641285426651,\n" +
//                    "\t\"type\": \"track\",\n" +
//                    "\t\"distinct_id\": \"0a630fe480e1038a\",\n" +
//                    "\t\"anonymous_id\": \"0a630fe480e1038a\",\n" +
//                    "\t\"identities\": {\n" +
//                    "\t\t\"$identity_android_id\": \"0a630fe480e1038a\"\n" +
//                    "\t},\n" +
//                    "\t\"lib\": {\n" +
//                    "\t\t\"$lib_method\": \"autoTrack\",\n" +
//                    "\t\t\"$lib\": \"Android\",\n" +
//                    "\t\t\"$lib_version\": \"6.1.1\",\n" +
//                    "\t\t\"$app_version\": \"1.0\",\n" +
//                    "\t\t\"$lib_detail\": \"com.statisticspro.LoginActivity######\"\n" +
//                    "\t},\n" +
//                    "\t\"event\": \"$AppViewScreen\",\n" +
//                    "\t\"properties\": {\n" +
//                    "\t\t\"$os_version\": \"11\",\n" +
//                    "\t\t\"$model\": \"21091116AG\",\n" +
//                    "\t\t\"$os\": \"Android\",\n" +
//                    "\t\t\"$screen_width\": 1080,\n" +
//                    "\t\t\"$brand\": \"REDMI\",\n" +
//                    "\t\t\"$screen_height\": 2400,\n" +
//                    "\t\t\"$app_version\": \"1.0\",\n" +
//                    "\t\t\"$lib\": \"Android\",\n" +
//                    "\t\t\"$device_id\": \"0a630fe480e1038a\",\n" +
//                    "\t\t\"$app_name\": \"StatisticsPro\",\n" +
//                    "\t\t\"$lib_version\": \"6.1.1\",\n" +
//                    "\t\t\"$timezone_offset\": -480,\n" +
//                    "\t\t\"$app_id\": \"com.statisticspro\",\n" +
//                    "\t\t\"$manufacturer\": \"XIAOMI\",\n" +
//                    "\t\t\"platform\": \"Android\",\n" +
//                    "\t\t\"$referrer_title\": \"StatisticsPro\",\n" +
//                    "\t\t\"$wifi\": true,\n" +
//                    "\t\t\"$network_type\": \"WIFI\",\n" +
//                    "\t\t\"$referrer\": \"com.statisticspro.LoginActivity\",\n" +
//                    "\t\t\"$url\": \"com.statisticspro.LoginActivity\",\n" +
//                    "\t\t\"$screen_name\": \"com.statisticspro.LoginActivity\",\n" +
//                    "\t\t\"$title\": \"StatisticsPro\",\n" +
//                    "\t\t\"$lib_method\": \"autoTrack\",\n" +
//                    "\t\t\"$is_first_day\": false\n" +
//                    "\t},\n" +
//                    "\t\"_flush_time\": 1641285433840\n" +
//                    "}]\n");
//            System.out.println(s);
//        } catch (InvalidDataException e) {
//            e.printStackTrace();
//        }
    }
}


