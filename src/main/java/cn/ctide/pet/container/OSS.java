package cn.ctide.pet.container;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;

import java.io.File;
import java.net.URL;
import java.util.Date;


/**
 * OSS 上传
 * @author 
 *
 */
public enum OSS {
	INSTANCE {

	};
	private final static String ENDPOINT = "https://oss-cn-shenzhen.aliyuncs.com";
	private final static String OSS_ACCESS_ID = "LTAIudY6d6WLymtv";
	private final static String OSS_ACCESS_KEY = "AhHhYMRUzGMyqImRnhop6w7ur4Tu0K";
	private final static String OSS_BUCKET = "ctide";

	public String USER_STYLE = "image/resize,m_fill,h_100,w_100/format,png";
	public String PET_STYLE = "image/resize,m_mfit,h_100,w_100/format,png";

	public void upload(String ossPath, File local) {
	    OSSClient client = new OSSClient(ENDPOINT, OSS_ACCESS_ID, OSS_ACCESS_KEY);
        client.deleteObject(OSS_BUCKET, ossPath + local.getName());
		client.putObject(OSS_BUCKET, ossPath + local.getName(), local);
		client.shutdown();
	}

	public String generateUrl(String key, String style) {
        Date expiration = new Date(new Date().getTime() + 1000 * 60 * 10 );
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(OSS_BUCKET, key, HttpMethod.GET);
        req.setExpiration(expiration);
        req.setProcess(style);
        OSSClient client = new OSSClient(ENDPOINT, OSS_ACCESS_ID, OSS_ACCESS_KEY);
        URL signedUrl = client.generatePresignedUrl(req);
        client.shutdown();
        return signedUrl.toString();
    }
}
