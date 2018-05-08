package cn.catering.alipay;


import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @ClassName:  AlipayConfig   
 * @Description:设置帐户有关信息及返回路径
 * @author: Sun
 * @date:   2018年4月18日 下午4:38:55
 */
public class AlipayConfig {
	
	// 应用APPID，收款账号既是APPID对应支付宝账号
	public static String app_id = "2016091500519637";
	
	// 商户私钥，PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCBFa/auSMbd6gSG7OwL9lXjGPJZQ0ZSx2Mujd4XfUy8Dtj3i/t4LmkEw8gujMQBjVJ4pRQ0ZXaLSYZgx6g9wL8F/b4+hZ2FWtmmKdebSwvzQ+jrH0RMVBHi6onw6XXPFKpt7CYpgY55UijTPFbew0OY0PJ4qnhYD1VSnWBo4D84sEAzlQf4z2fgE9oDAN2VlgArtUFEXNRL7RaZ//NiuXumSHMYtdk2KmG2yAMpnEXRewVuEaEvNTmw6SN9eFXtk9zEjjcfo841kreT2QfoLUfyPyS1mJ1uXnDauk0u6qdjFZEytPh0z29Df30UMCm+86SRzvJujprBbtGpUr78ikHAgMBAAECggEAOtFM7dbKHmvpU0b4G2HSIMhBd7TpwQqvDj6To+78GRfJl/nX0QZC0HY2wGzXc4fApEfv2NuG8oD8CUfrnuCupXut90jND0U3SOpp6ObJ6YYAiE3CNyFHOTJ0d+X4HRjJebfPad7Mm3jUHkSi/VIWYuXsL4NucNlPWRuyaz27On7aShcFjPKVktLYuGXBHbNKDyl6XaVNDoeWeU++96ahJD6xh+DSxo8SWadOqVbx4k47Lpvjpp0ph/7VxMrMx0YqkbctVxeAfeHvA1/QrAdSkevh9lGyQpVHCr6EMYxtYpt4JrxuqLK1T2B6KsiXaLIFTubOJVroP3dMunTGn6/rEQKBgQC57Uez5i+VOzddjm6a2YVD25TK5RVWSBSGXvuV5snZ26ZxcGgZmffc8/UiR8HybaOV+9/FgwAs1iEDSu9CUxQZwo41BO4evQGns2jQxIjX/GDJ4yNdRd5CAAJuQYMe0gaLwAW+RD7/7B9No860lva76ULlhyvfZJRNMsgiwdXEAwKBgQCxvB+0TZbmdrIVxsSSvmsiJiJpHmSky53jeiCK03Og1p1BLsfh0hA7p031iKEeleGowJx1Qf3O7IpwiZMqs8ACkAKKPlyT5P9oZgux/wn0Iw9rXiQSrZan8kVKItzt8b/1moXFaorPtO9/nEAe8ig9BNjzI+hxDdHNqoJCZ32RrQKBgQCCE0koyQ/dHbKcV3t2Blw/ny23zRFibcc+QtFMjEwHiK4nivapgphwEpUbSIydqKrb0X06V24V8DDkdtZw1mKnqv+GhE57Xsv7oX7hH76FLOIiHDCvnqPiFNOeg2LSeyltOAhMlr5kmbNExCdnHH699HGC11CQV3ORlseB2Y5ONQKBgQCABYe4seKt4nVoJiJVqP82O82xdgj8gwYZYlCqbqDtC2l+GBo12L+EmIAZCe80PrWqfgK0m3IcaFlXsmDk81CtB9oshbrddKdcJZTrA0/CILbsmYTWR18rXeD3A6GrauTgHguZJaMS9btFaeDt6XN+cE1s5UJ6nH+w6s6k0jKqiQKBgByRlPYUdNYe/aqwsre4abVcWEv7+m3+HaZBeNnfidavy/aUPKo1m76W/wq4rZnpvGGDGpCvUS6A4dWEycJEUmC7ToTAnfTnrN3/g6SbWfLMjneV3Hl5ZTGfSbrbTike0XG8mVeu3+6Q6qVyZQZJqlXucoClZgkKm+Q+EG85O6rB";
	
	// 支付宝公钥，对应APPID下的支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA00PTkSCfkVBKtGiVSVrBn0lHj6FriP6TZYM2ZJFc6plNe15mH3o9WcKtDd+kg4dfuM0L9rndJp5jDE4U77kcLol4CkHEjheyI9CFjNELSFuTfVrI8ylaKgXBGB+IQX2LaJmzNOpjiCunIfUUVZG1wLiccCbR8aDh7gV7JY/Oo8Q8XW0JUVgnA9x+kVahu0g8pD45+zpEzwGCjnjgh6sP/gqCIFwHSfFUFcnpQnBqdSAdd6KaQwqp3hIZrC1YUJ3yxk+88KZOfDjues5cbUkHg6rb1peaibyqAs7cybCJ3tm7qXR3w6d1voQ6gPAgxpWOYaGGXhTiuYfZPr+Y6q20zQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://javaweb.w3.luyouxia.net/";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://javaweb.w3.luyouxia.net/";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}