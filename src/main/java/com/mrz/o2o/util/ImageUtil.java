package com.mrz.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mrz.o2o.dto.ImageHolder;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	// transferCommonsMultiparFileToFile
	public static File transferCommonsMultiparFileToFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFile;

	}

	// 定义时间date对象
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyMMddHHmmss");
	// 得到项目路径
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	// 定义随机数对像
	private static final Random r = new Random();
	private static Logger looger = LoggerFactory.getLogger(ImageUtil.class);

	public static String GenerateThumbnail(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();

		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName+extension;
		looger.debug("current relativeAddr is" + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		looger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails
					.of(thumbnail.getImage()).size(200, 200).watermark(Positions.BOTTOM_RIGHT,
							ImageIO.read(new File(basePath + "/QQ图片20190320130943.png")), 0.25f)
					.outputQuality(0.8f).toFile(dest);

		} catch (IOException e) {
			looger.debug(e.getMessage());
			e.printStackTrace();

		}
		return relativeAddr;
	}

	// 创建目录
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	private static String getFileExtension(String thumbnail) {
		String originalFileName = thumbnail;
		// substring从第几个字符串后开始输出。
		return originalFileName.substring(originalFileName.lastIndexOf("."));

	}

	// 自动获取随机名字
	public static String getRandomFileName() {
		// 获得00000-999999的随机数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;

	}

	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if (fileOrPath.exists()) {
			if (fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();

				}

			}
			fileOrPath.delete();

		}

	}
	public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();

		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName+extension;
		looger.debug("current relativeAddr is" + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		looger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails
					.of(thumbnail.getImage()).size(337, 640).watermark(Positions.BOTTOM_RIGHT,
							ImageIO.read(new File(basePath + "/QQ图片20190320130943.png")), 0.25f)
					.outputQuality(0.9f).toFile(dest);

		} catch (IOException e) {
			looger.debug(e.getMessage());
			e.printStackTrace();

		}
		return relativeAddr;
}
}