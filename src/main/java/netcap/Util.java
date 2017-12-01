package netcap;

/**
 * @author Andrew
 * @date 2017/11/5
 */
public class Util {
    /**
     * 将16进制mac地址转换为byte数组
     * @param mac 电脑mac地址十六进制 如"38-B1-DB-51-6B-F3"
     * @return 将16进制mac地址转换为byte数组
     */
    public static byte[] toByte(String mac){
        String[] arr = mac.split("-");
        byte[] macByte = new byte[6];
        for (int i = 0;i < arr.length;i++){
            Integer ad = Integer.parseInt(arr[i],16);
            macByte[i] = ad.byteValue();
        }
        return macByte;
    }

    /**
     * 将16进制int数组转换为byte数组
     * @param stringArray 16进制数组
     * @return byte数组
     */
    public static byte[] toByteArray(String[] stringArray){
        int length = stringArray.length;
        byte[] byteArray = new byte[length];
        for (int i = 0;i < length;i++){
            Integer ad = Integer.parseInt(stringArray[i],16);
            byteArray[i] = ad.byteValue();
//            byteArray[i] = (byte)(stringArray[i] & 0xff);
        }
        return byteArray;
    }
}
