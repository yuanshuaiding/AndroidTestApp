package com.example.yuans.testapplication.anim;

/**
 * 动画运动到某个坐标点封装（目标坐标及如何运动到目标）
 * Created by yuans on 2017/3/2.
 */

public class AnimPoint {
    public static final int MOVE_TO = 0x1000;//移动到目标位置
    public static final int LINE_TO = 0x1001;//直线运动到目标位置
    public static final int CURVE_TO = 0x1002;//曲线运动到目标位置（贝塞尔曲线）

    public int type;
    public float x, y;
    public float c0x, c0y, c1x, c1y;//贝塞尔曲线的曲点

    public AnimPoint(int moveType, float x, float y) {
        this.x = x;
        this.y = y;
        this.type = moveType;
    }

    public AnimPoint(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        this.x = x;
        this.y = y;
        this.c0x = c0x;
        this.c0y = c0y;
        this.c1x = c1x;
        this.c1y = c1y;
        this.type = CURVE_TO;
    }

    public static AnimPoint moveTo(float x, float y) {
        return new AnimPoint(MOVE_TO, x, y);
    }

    public static AnimPoint lineTo(float x, float y) {
        return new AnimPoint(LINE_TO, x, y);
    }

    public static AnimPoint curveTo(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        return new AnimPoint(c0x, c0y, c1x, c1y, x, y);
    }
}
