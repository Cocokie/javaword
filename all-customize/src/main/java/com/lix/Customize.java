package com.lix;

import com.lix.domain.Dish;
import com.lix.domain.User;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customize {
    public static void main(String[] args) throws Exception {
        //FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("http://172.20.1.12:8002/live?port=1935&app=hls&stream=jie");
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("http://cctvalih5ca.v.myalicdn.com/live/cctv1_2/index.m3u8");
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("jie");//新建一个窗口
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);
        while (true) {
            if (!canvas.isDisplayable()) {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(-1);//退出
            }
            Frame frame = grabber.grab();

            canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            //毫秒刷新一次图像
            Thread.sleep(5);
        }
    }

}

