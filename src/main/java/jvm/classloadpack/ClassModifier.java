package jvm.classloadpack;

/**
 * Created by Andrew  on 2017/3/17.
 */
public class ClassModifier {
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    private static final int CONSTANT_UTF8_info = 1;

    private static final int[] CONSTANT_KENGTH =
            {-1,-1,-1,5,5,9,9,3,3,5,5,5,5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[]classByte;

    public ClassModifier(byte[]classByte){
        this.classByte=classByte;
    }

    public byte[]modifyUTF8Constant(String oldStr,String newStr){
        int cpc =  getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX+2;
        for (int i=2;i<cpc;i++){
            int tag = ByteUtils.bytes2Int(classByte,offset,u1);
            if (tag == CONSTANT_UTF8_info){
                int len = ByteUtils.bytes2Int(classByte,offset,u1);
                offset +=(u1+u2);
                String str = ByteUtils.bytes2String(classByte,offset,len);
                if (str.equalsIgnoreCase(oldStr)){
                    byte[] strBytes = ByteUtils.string2Byte(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(),u2);
                    classByte = ByteUtils.byteReplace(classByte,offset-u2,u2,strLen);
                    classByte = ByteUtils.byteReplace(classByte,offset,len,strBytes);
                    return classByte;
                }else {
                    offset += len;
                }
            }else {
                offset += CONSTANT_KENGTH[tag];
            }
        }
        return classByte;
    }


    public int getConstantPoolCount(){
        return 1;
    }
}
